export async function TextToSpeech(inputText) {
    // BEGIN USER CODE
    if (!inputText) {
        return false;
    }
    if ("speechSynthesis" in window === false) {
        throw new Error("Browser does not support text to speech");
    }
    return new Promise(function (resolve, reject) {
        const utterance = new SpeechSynthesisUtterance(inputText);
        utterance.onend = function () {
            resolve(true);
        };
        utterance.onerror = function (event) {
            reject("An error occurred during playback: " + event.error);
        };
        window.speechSynthesis.speak(utterance);
    });

    // END USER CODE
}
