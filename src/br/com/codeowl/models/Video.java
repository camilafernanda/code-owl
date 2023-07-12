package br.com.codeowl.models;

public class Video extends Activity {
    private String url;
    private int minutesDuration;
    private String transcription;

    public Video(String title, String code, Section section, String url) {
        super(title, code, section);
        if (url==null || url.isEmpty()) {
            throw new IllegalArgumentException("A url do vídeo é obrigatória.");
        }
        this.url = url;
    }

    public void setMinutesDuration(int minutesDuration) {
        this.minutesDuration = minutesDuration;
    }

    public void setTranscription(String transcription) {
        this.transcription = transcription;
    }

    @Override
    public String toString() {
        return "*** Atividade " + super.getSequence() + " ***" + "\n" +
                "Título: " + super.getTitle() + "\n" +
                "Código " + super.getCode() + "\n" +
                "** Tipo: vídeo **" + "\n" +
                "Url: " + url + "\n" +
                "Duração: " + minutesDuration + " minutos" + "\n" +
                "Transcrição: " + transcription + "\n";
    }
}
