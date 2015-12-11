.class public Lco/vine/android/recorder/EncoderManager;
.super Ljava/lang/Object;
.source "EncoderManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/recorder/EncoderManager$Encoder;,
        Lco/vine/android/recorder/EncoderManager$EncoderBoss;,
        Lco/vine/android/recorder/EncoderManager$EncodingException;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    return-void
.end method

.method public static transcode(Lco/vine/android/recorder/EncoderManager$EncoderBoss;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p0, "boss"    # Lco/vine/android/recorder/EncoderManager$EncoderBoss;
    .param p1, "input"    # Ljava/lang/String;
    .param p2, "output"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/recorder/EncoderManager$EncodingException;
        }
    .end annotation

    .prologue
    .line 16
    const-string v0, "Start transcoding from {} to {}."

    invoke-static {v0, p1, p2}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 18
    new-instance v0, Lco/vine/android/lifevibes/LifeVibesTranscoder;

    invoke-direct {v0}, Lco/vine/android/lifevibes/LifeVibesTranscoder;-><init>()V

    const/4 v1, 0x0

    invoke-virtual {v0, p0, p1, p2, v1}, Lco/vine/android/lifevibes/LifeVibesTranscoder;->transcode(Lco/vine/android/recorder/EncoderManager$EncoderBoss;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 19
    return-void
.end method

.method public static tryLoad()V
    .locals 1

    .prologue
    .line 22
    new-instance v0, Lco/vine/android/lifevibes/LifeVibesTranscoder;

    invoke-direct {v0}, Lco/vine/android/lifevibes/LifeVibesTranscoder;-><init>()V

    .line 23
    return-void
.end method
