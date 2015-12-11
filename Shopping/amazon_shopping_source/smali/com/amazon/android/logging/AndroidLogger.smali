.class Lcom/amazon/android/logging/AndroidLogger;
.super Lcom/amazon/logging/Logger;
.source "AndroidLogger.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/android/logging/AndroidLogger$Level;
    }
.end annotation


# static fields
.field private static defaultLevel:Ljava/lang/String;


# instance fields
.field private final tag:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    const-string/jumbo v0, "3"

    sput-object v0, Lcom/amazon/android/logging/AndroidLogger;->defaultLevel:Ljava/lang/String;

    return-void
.end method

.method constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    .line 94
    invoke-direct {p0}, Lcom/amazon/logging/Logger;-><init>()V

    .line 95
    iput-object p1, p0, Lcom/amazon/android/logging/AndroidLogger;->tag:Ljava/lang/String;

    .line 96
    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 11
    sget-object v0, Lcom/amazon/android/logging/AndroidLogger;->defaultLevel:Ljava/lang/String;

    return-object v0
.end method

.method protected static setIsDebugBuild(Z)V
    .locals 1
    .param p0, "isDebugEnabled"    # Z

    .prologue
    .line 25
    if-eqz p0, :cond_0

    .line 26
    const-string/jumbo v0, "5"

    sput-object v0, Lcom/amazon/android/logging/AndroidLogger;->defaultLevel:Ljava/lang/String;

    .line 30
    :goto_0
    return-void

    .line 28
    :cond_0
    const-string/jumbo v0, "3"

    sput-object v0, Lcom/amazon/android/logging/AndroidLogger;->defaultLevel:Ljava/lang/String;

    goto :goto_0
.end method


# virtual methods
.method public d(Ljava/lang/String;)V
    .locals 1
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 101
    sget-object v0, Lcom/amazon/android/logging/AndroidLogger$Level;->debug:Lcom/amazon/android/logging/AndroidLogger$Level;

    invoke-virtual {v0}, Lcom/amazon/android/logging/AndroidLogger$Level;->isEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 102
    iget-object v0, p0, Lcom/amazon/android/logging/AndroidLogger;->tag:Ljava/lang/String;

    invoke-static {v0, p1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 104
    :cond_0
    return-void
.end method

.method public d(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1
    .param p1, "msg"    # Ljava/lang/String;
    .param p2, "tr"    # Ljava/lang/Throwable;

    .prologue
    .line 109
    sget-object v0, Lcom/amazon/android/logging/AndroidLogger$Level;->debug:Lcom/amazon/android/logging/AndroidLogger$Level;

    invoke-virtual {v0}, Lcom/amazon/android/logging/AndroidLogger$Level;->isEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 110
    iget-object v0, p0, Lcom/amazon/android/logging/AndroidLogger;->tag:Ljava/lang/String;

    invoke-static {v0, p1, p2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 112
    :cond_0
    return-void
.end method

.method public e(Ljava/lang/String;)V
    .locals 1
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 123
    sget-object v0, Lcom/amazon/android/logging/AndroidLogger$Level;->error:Lcom/amazon/android/logging/AndroidLogger$Level;

    invoke-virtual {v0}, Lcom/amazon/android/logging/AndroidLogger$Level;->isEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 124
    iget-object v0, p0, Lcom/amazon/android/logging/AndroidLogger;->tag:Ljava/lang/String;

    invoke-static {v0, p1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 126
    :cond_0
    return-void
.end method

.method public e(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1
    .param p1, "msg"    # Ljava/lang/String;
    .param p2, "tr"    # Ljava/lang/Throwable;

    .prologue
    .line 131
    sget-object v0, Lcom/amazon/android/logging/AndroidLogger$Level;->error:Lcom/amazon/android/logging/AndroidLogger$Level;

    invoke-virtual {v0}, Lcom/amazon/android/logging/AndroidLogger$Level;->isEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 132
    iget-object v0, p0, Lcom/amazon/android/logging/AndroidLogger;->tag:Ljava/lang/String;

    invoke-static {v0, p1, p2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 134
    :cond_0
    return-void
.end method

.method public i(Ljava/lang/String;)V
    .locals 1
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 139
    sget-object v0, Lcom/amazon/android/logging/AndroidLogger$Level;->informational:Lcom/amazon/android/logging/AndroidLogger$Level;

    invoke-virtual {v0}, Lcom/amazon/android/logging/AndroidLogger$Level;->isEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 140
    iget-object v0, p0, Lcom/amazon/android/logging/AndroidLogger;->tag:Ljava/lang/String;

    invoke-static {v0, p1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 142
    :cond_0
    return-void
.end method

.method public i(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1
    .param p1, "msg"    # Ljava/lang/String;
    .param p2, "tr"    # Ljava/lang/Throwable;

    .prologue
    .line 147
    sget-object v0, Lcom/amazon/android/logging/AndroidLogger$Level;->informational:Lcom/amazon/android/logging/AndroidLogger$Level;

    invoke-virtual {v0}, Lcom/amazon/android/logging/AndroidLogger$Level;->isEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 148
    iget-object v0, p0, Lcom/amazon/android/logging/AndroidLogger;->tag:Ljava/lang/String;

    invoke-static {v0, p1, p2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 150
    :cond_0
    return-void
.end method

.method public isDebugEnabled()Z
    .locals 1

    .prologue
    .line 117
    sget-object v0, Lcom/amazon/android/logging/AndroidLogger$Level;->debug:Lcom/amazon/android/logging/AndroidLogger$Level;

    invoke-virtual {v0}, Lcom/amazon/android/logging/AndroidLogger$Level;->isEnabled()Z

    move-result v0

    return v0
.end method

.method public isVerboseEnabled()Z
    .locals 1

    .prologue
    .line 171
    sget-object v0, Lcom/amazon/android/logging/AndroidLogger$Level;->verbose:Lcom/amazon/android/logging/AndroidLogger$Level;

    invoke-virtual {v0}, Lcom/amazon/android/logging/AndroidLogger$Level;->isEnabled()Z

    move-result v0

    return v0
.end method

.method public v(Ljava/lang/String;)V
    .locals 1
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 155
    sget-object v0, Lcom/amazon/android/logging/AndroidLogger$Level;->verbose:Lcom/amazon/android/logging/AndroidLogger$Level;

    invoke-virtual {v0}, Lcom/amazon/android/logging/AndroidLogger$Level;->isEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 156
    iget-object v0, p0, Lcom/amazon/android/logging/AndroidLogger;->tag:Ljava/lang/String;

    invoke-static {v0, p1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 158
    :cond_0
    return-void
.end method

.method public v(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1
    .param p1, "msg"    # Ljava/lang/String;
    .param p2, "tr"    # Ljava/lang/Throwable;

    .prologue
    .line 163
    sget-object v0, Lcom/amazon/android/logging/AndroidLogger$Level;->verbose:Lcom/amazon/android/logging/AndroidLogger$Level;

    invoke-virtual {v0}, Lcom/amazon/android/logging/AndroidLogger$Level;->isEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 164
    iget-object v0, p0, Lcom/amazon/android/logging/AndroidLogger;->tag:Ljava/lang/String;

    invoke-static {v0, p1, p2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 166
    :cond_0
    return-void
.end method

.method public w(Ljava/lang/String;)V
    .locals 1
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 177
    sget-object v0, Lcom/amazon/android/logging/AndroidLogger$Level;->warning:Lcom/amazon/android/logging/AndroidLogger$Level;

    invoke-virtual {v0}, Lcom/amazon/android/logging/AndroidLogger$Level;->isEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 178
    iget-object v0, p0, Lcom/amazon/android/logging/AndroidLogger;->tag:Ljava/lang/String;

    invoke-static {v0, p1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 180
    :cond_0
    return-void
.end method

.method public w(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1
    .param p1, "msg"    # Ljava/lang/String;
    .param p2, "tr"    # Ljava/lang/Throwable;

    .prologue
    .line 185
    sget-object v0, Lcom/amazon/android/logging/AndroidLogger$Level;->warning:Lcom/amazon/android/logging/AndroidLogger$Level;

    invoke-virtual {v0}, Lcom/amazon/android/logging/AndroidLogger$Level;->isEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 186
    iget-object v0, p0, Lcom/amazon/android/logging/AndroidLogger;->tag:Ljava/lang/String;

    invoke-static {v0, p1, p2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 188
    :cond_0
    return-void
.end method
