package com.adonai.tool.media;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer {
	public void play(File file) {
		try {
			AudioInputStream in = AudioSystem.getAudioInputStream(file);
			AudioFormat outFormat = getOutFormat(in.getFormat());
			Info info = new Info(SourceDataLine.class, outFormat);

			SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
			if (line != null) {
				// line.open(outFormat);
				line.open();
				line.start();
				stream(AudioSystem.getAudioInputStream(outFormat, in), line);
				line.drain();
				line.stop();
			}
			in.close();
		} catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
			e.printStackTrace();
			// throw new IllegalStateException(e);
		}
	}

	private AudioFormat getOutFormat(AudioFormat informat) {
		int ch = informat.getChannels();
		float rate = informat.getSampleRate();
		return new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, rate, 16, ch, ch * 2, rate, false);
	}

	private void stream(AudioInputStream in, SourceDataLine line) throws IOException {
		byte[] buffer = new byte[4096];
		for (int n = 0; n != -1; n = in.read(buffer, 0, buffer.length)) {
			line.write(buffer, 0, n);
		}
	}
}