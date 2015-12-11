.class public Lcom/comcast/cim/android/accessibility/AlternateInterfaceUtil;
.super Ljava/lang/Object;
.source "AlternateInterfaceUtil.java"


# static fields
.field private static readMode:Z


# instance fields
.field protected shortCircuitTalk:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 8
    const/4 v0, 0x1

    sput-boolean v0, Lcom/comcast/cim/android/accessibility/AlternateInterfaceUtil;->readMode:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 9
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/cim/android/accessibility/AlternateInterfaceUtil;->shortCircuitTalk:Z

    .line 11
    return-void
.end method


# virtual methods
.method public getAndToggleShortCircuitTalk()Z
    .locals 2

    .prologue
    const/4 v0, 0x0

    .line 27
    iget-boolean v1, p0, Lcom/comcast/cim/android/accessibility/AlternateInterfaceUtil;->shortCircuitTalk:Z

    if-eqz v1, :cond_0

    .line 28
    iput-boolean v0, p0, Lcom/comcast/cim/android/accessibility/AlternateInterfaceUtil;->shortCircuitTalk:Z

    .line 29
    const/4 v0, 0x1

    .line 32
    :cond_0
    return v0
.end method

.method public getReadMode()Z
    .locals 1

    .prologue
    .line 18
    sget-boolean v0, Lcom/comcast/cim/android/accessibility/AlternateInterfaceUtil;->readMode:Z

    return v0
.end method

.method public getShortCircuitTalk()Z
    .locals 1

    .prologue
    .line 36
    iget-boolean v0, p0, Lcom/comcast/cim/android/accessibility/AlternateInterfaceUtil;->shortCircuitTalk:Z

    return v0
.end method

.method public interpretIfNumber(Ljava/lang/String;)I
    .locals 2
    .param p1, "str"    # Ljava/lang/String;

    .prologue
    .line 55
    const/4 v0, -0x1

    .line 57
    .local v0, "retval":I
    const-string v1, "won"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string v1, "one"

    .line 58
    invoke-virtual {p1, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 60
    :cond_0
    const/4 v0, 0x1

    .line 89
    :goto_0
    return v0

    .line 62
    :cond_1
    const-string v1, "to"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    const-string v1, "too"

    .line 63
    invoke-virtual {p1, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    const-string v1, "two"

    .line 64
    invoke-virtual {p1, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 66
    :cond_2
    const/4 v0, 0x2

    goto :goto_0

    .line 68
    :cond_3
    const-string v1, "for"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_4

    const-string v1, "fore"

    .line 69
    invoke-virtual {p1, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_4

    const-string v1, "four"

    .line 70
    invoke-virtual {p1, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 72
    :cond_4
    const/4 v0, 0x4

    goto :goto_0

    .line 74
    :cond_5
    const-string v1, "ate"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_6

    const-string v1, "eight"

    .line 75
    invoke-virtual {p1, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_7

    .line 77
    :cond_6
    const/16 v0, 0x8

    goto :goto_0

    .line 83
    :cond_7
    :try_start_0
    invoke-static {p1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    goto :goto_0

    .line 84
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public isReadModeOn()Z
    .locals 1

    .prologue
    .line 22
    sget-boolean v0, Lcom/comcast/cim/android/accessibility/AlternateInterfaceUtil;->readMode:Z

    return v0
.end method

.method public setReadMode(Z)V
    .locals 0
    .param p1, "isReadModeOn"    # Z

    .prologue
    .line 14
    sput-boolean p1, Lcom/comcast/cim/android/accessibility/AlternateInterfaceUtil;->readMode:Z

    .line 15
    return-void
.end method

.method public setShortCircuitTalk(Z)V
    .locals 0
    .param p1, "shortCircuitTalk"    # Z

    .prologue
    .line 40
    iput-boolean p1, p0, Lcom/comcast/cim/android/accessibility/AlternateInterfaceUtil;->shortCircuitTalk:Z

    .line 41
    return-void
.end method
