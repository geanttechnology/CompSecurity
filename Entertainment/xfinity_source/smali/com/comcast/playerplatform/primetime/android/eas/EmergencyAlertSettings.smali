.class public Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;
.super Ljava/lang/Object;
.source "EmergencyAlertSettings.java"


# instance fields
.field private alertPollingInterval:I

.field private alertRepeatCount:I

.field private backgroundColor:I

.field private hasBackground:Z

.field private textColor:I

.field private textSize:I


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    iput-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;->hasBackground:Z

    .line 16
    const/4 v0, -0x1

    iput v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;->textColor:I

    .line 17
    const/high16 v0, -0x1000000

    iput v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;->backgroundColor:I

    .line 18
    const/16 v0, 0x3a98

    iput v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;->alertPollingInterval:I

    .line 19
    iput v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;->alertRepeatCount:I

    .line 20
    const/16 v0, 0x16

    iput v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;->textSize:I

    .line 24
    return-void
.end method


# virtual methods
.method public getAlertPollingInterval()I
    .locals 1

    .prologue
    .line 86
    iget v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;->alertPollingInterval:I

    return v0
.end method

.method public getAlertRepeatCount()I
    .locals 1

    .prologue
    .line 104
    iget v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;->alertRepeatCount:I

    return v0
.end method

.method public getBackgroundColor()I
    .locals 1

    .prologue
    .line 40
    iget v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;->backgroundColor:I

    return v0
.end method

.method public getHasBackground()Z
    .locals 1

    .prologue
    .line 27
    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;->hasBackground:Z

    return v0
.end method

.method public getTextColor()I
    .locals 1

    .prologue
    .line 62
    iget v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;->textColor:I

    return v0
.end method

.method public getTextSize()F
    .locals 1

    .prologue
    .line 124
    iget v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;->textSize:I

    int-to-float v0, v0

    return v0
.end method

.method public setAlertPollingInterval(I)V
    .locals 0
    .param p1, "alertPollingInterval"    # I

    .prologue
    .line 95
    iput p1, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;->alertPollingInterval:I

    .line 96
    return-void
.end method

.method public setAlertRepeatCount(I)V
    .locals 0
    .param p1, "alertRepeatCount"    # I

    .prologue
    .line 113
    if-ltz p1, :cond_0

    .line 114
    iput p1, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;->alertRepeatCount:I

    .line 116
    :cond_0
    return-void
.end method

.method public setBackgroundColor(Ljava/lang/String;)V
    .locals 1
    .param p1, "backgroundColor"    # Ljava/lang/String;

    .prologue
    .line 50
    :try_start_0
    invoke-static {p1}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;->backgroundColor:I
    :try_end_0
    .catch Ljava/lang/EnumConstantNotPresentException; {:try_start_0 .. :try_end_0} :catch_0

    .line 54
    :goto_0
    return-void

    .line 51
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public setHasBackground(Z)V
    .locals 0
    .param p1, "hasBackground"    # Z

    .prologue
    .line 31
    iput-boolean p1, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;->hasBackground:Z

    .line 32
    return-void
.end method

.method public setTextColor(Ljava/lang/String;)V
    .locals 1
    .param p1, "textColor"    # Ljava/lang/String;

    .prologue
    .line 72
    :try_start_0
    invoke-static {p1}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    .line 73
    invoke-static {p1}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;->textColor:I
    :try_end_0
    .catch Ljava/lang/EnumConstantNotPresentException; {:try_start_0 .. :try_end_0} :catch_0

    .line 77
    :goto_0
    return-void

    .line 74
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public setTextSize(I)V
    .locals 0
    .param p1, "textSize"    # I

    .prologue
    .line 133
    iput p1, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;->textSize:I

    .line 134
    return-void
.end method
