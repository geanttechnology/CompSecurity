.class public Lcom/comcast/playerplatform/primetime/android/eas/Alert;
.super Ljava/lang/Object;
.source "Alert.java"


# instance fields
.field private areaDescription:Ljava/lang/String;

.field private description:Ljava/lang/String;

.field private effective:Ljava/lang/String;

.field private event:Ljava/lang/String;

.field private eventCode:Ljava/lang/String;

.field private expires:Ljava/lang/String;

.field private identifier:Ljava/lang/String;

.field private instruction:Ljava/lang/String;

.field private replaceContentUri:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/util/HashMap;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 46
    .local p1, "alertValues":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 47
    const-string v0, "identifier"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->identifier:Ljava/lang/String;

    .line 48
    const-string v0, "event"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->event:Ljava/lang/String;

    .line 49
    const-string v0, "eventCode"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->eventCode:Ljava/lang/String;

    .line 50
    const-string v0, "effective"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->decorateTime(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->effective:Ljava/lang/String;

    .line 51
    const-string v0, "expires"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->decorateTime(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->expires:Ljava/lang/String;

    .line 52
    const-string v0, "areaDesc"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->areaDescription:Ljava/lang/String;

    .line 54
    const-string v0, "description"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 55
    const-string v0, "description"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->description:Ljava/lang/String;

    .line 57
    :cond_0
    const-string v0, "instruction"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 58
    const-string v0, "instruction"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->instruction:Ljava/lang/String;

    .line 60
    :cond_1
    const-string v0, "resource"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 61
    const-string v0, "resource"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->replaceContentUri:Ljava/lang/String;

    .line 64
    :cond_2
    return-void
.end method

.method private decorateTime(Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p1, "time"    # Ljava/lang/String;

    .prologue
    .line 106
    return-object p1
.end method


# virtual methods
.method public getAlertMessage()Ljava/lang/String;
    .locals 2

    .prologue
    .line 110
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 112
    .local v0, "alertMessage":Ljava/lang/StringBuffer;
    const-string v1, "A "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 113
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->event:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 114
    const-string v1, " has been issued for the following counties: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 115
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->areaDescription:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 116
    const-string v1, " effective "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 117
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->effective:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 118
    const-string v1, " until "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 119
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->expires:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 120
    const-string v1, ". "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 121
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->description:Ljava/lang/String;

    invoke-static {v1}, Lcom/comcast/playerplatform/util/android/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 122
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->description:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 123
    const-string v1, ". "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 125
    :cond_0
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->instruction:Ljava/lang/String;

    invoke-static {v1}, Lcom/comcast/playerplatform/util/android/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 126
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->instruction:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 127
    const-string v1, ". "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 130
    :cond_1
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->description:Ljava/lang/String;

    return-object v0
.end method

.method public getIdentifier()Ljava/lang/String;
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->identifier:Ljava/lang/String;

    return-object v0
.end method

.method public getReplaceContentUri()Ljava/lang/String;
    .locals 2

    .prologue
    .line 67
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->replaceContentUri:Ljava/lang/String;

    const-string v1, ".m3u8"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 68
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->replaceContentUri:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ".m3u8"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 70
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->replaceContentUri:Ljava/lang/String;

    goto :goto_0
.end method

.method public hasMediaUrl()Z
    .locals 2

    .prologue
    .line 87
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->replaceContentUri:Ljava/lang/String;

    invoke-static {v0}, Lcom/comcast/playerplatform/util/android/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->replaceContentUri:Ljava/lang/String;

    const-string v1, ".wav"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isEmergencyActionNotification()Z
    .locals 2

    .prologue
    .line 134
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->eventCode:Ljava/lang/String;

    invoke-static {v0}, Lcom/comcast/playerplatform/util/android/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->eventCode:Ljava/lang/String;

    const-string v1, "EAN"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setDescription(Ljava/lang/String;)V
    .locals 0
    .param p1, "description"    # Ljava/lang/String;

    .prologue
    .line 95
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->description:Ljava/lang/String;

    .line 96
    return-void
.end method

.method public setIdentifier(Ljava/lang/String;)V
    .locals 0
    .param p1, "identifier"    # Ljava/lang/String;

    .prologue
    .line 83
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->identifier:Ljava/lang/String;

    .line 84
    return-void
.end method

.method public setReplaceContentUri(Ljava/lang/String;)V
    .locals 0
    .param p1, "replaceContentUri"    # Ljava/lang/String;

    .prologue
    .line 75
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->replaceContentUri:Ljava/lang/String;

    .line 76
    return-void
.end method
