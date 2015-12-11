.class public Lcom/adobe/ave/AudioTrackInfo;
.super Ljava/lang/Object;
.source "AudioTrackInfo.java"


# instance fields
.field public description:Ljava/lang/String;

.field public isAutoSelect:Z

.field public isDefault:Z

.field public isForced:Z

.field public language:Ljava/lang/String;


# direct methods
.method constructor <init>(Ljava/lang/String;Ljava/lang/String;ZZZ)V
    .locals 0
    .param p1, "aDesc"    # Ljava/lang/String;
    .param p2, "aLanguage"    # Ljava/lang/String;
    .param p3, "aIsDefault"    # Z
    .param p4, "aIsAutoSelect"    # Z
    .param p5, "aIsForced"    # Z

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    iput-object p1, p0, Lcom/adobe/ave/AudioTrackInfo;->description:Ljava/lang/String;

    .line 30
    iput-object p2, p0, Lcom/adobe/ave/AudioTrackInfo;->language:Ljava/lang/String;

    .line 31
    iput-boolean p3, p0, Lcom/adobe/ave/AudioTrackInfo;->isDefault:Z

    .line 32
    iput-boolean p4, p0, Lcom/adobe/ave/AudioTrackInfo;->isAutoSelect:Z

    .line 33
    iput-boolean p5, p0, Lcom/adobe/ave/AudioTrackInfo;->isForced:Z

    .line 34
    return-void
.end method
