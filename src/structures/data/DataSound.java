package structures.data;

import java.io.FileInputStream;
import java.io.InputStream;
import exceptions.ResourceFailedException;
import structures.IResource;
import sun.audio.AudioStream;

public class DataSound implements IResource {
	
	private String myFileName;
	private AudioStream myAudioStream;
	
	public DataSound(String fileName) {
		myFileName = fileName;
	}
	
	public String getFileName() {
		return myFileName;
	}
	
	public void setFileName(String fileName) {
		myFileName = fileName;
	}
	
	@Override
	public void load(String resourceFolder) throws ResourceFailedException {
            String url = resourceFolder + "/" + myFileName;
            try {
                InputStream in = new FileInputStream(url);
                myAudioStream = new AudioStream(in);
            } catch (Exception ex) {
                    String message = String.format("Failed to load image '%s' for DataSprite %s", url, myFileName);
                    throw new ResourceFailedException(message);
            }
	}
	
	public AudioStream getAudio() {
	    return myAudioStream;
	}

}