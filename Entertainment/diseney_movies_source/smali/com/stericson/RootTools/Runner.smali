.class Lcom/stericson/RootTools/Runner;
.super Ljava/lang/Thread;
.source "Runner.java"


# static fields
.field private static final LOG_TAG:Ljava/lang/String; = "RootTools::Runner"


# instance fields
.field binaryName:Ljava/lang/String;

.field context:Landroid/content/Context;

.field parameter:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "binaryName"    # Ljava/lang/String;
    .param p3, "parameter"    # Ljava/lang/String;

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 40
    iput-object p1, p0, Lcom/stericson/RootTools/Runner;->context:Landroid/content/Context;

    .line 41
    iput-object p2, p0, Lcom/stericson/RootTools/Runner;->binaryName:Ljava/lang/String;

    .line 42
    iput-object p3, p0, Lcom/stericson/RootTools/Runner;->parameter:Ljava/lang/String;

    .line 43
    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    .line 46
    const/4 v1, 0x0

    .line 49
    .local v1, "privateFilesPath":Ljava/lang/String;
    :try_start_0
    iget-object v2, p0, Lcom/stericson/RootTools/Runner;->context:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->getCanonicalPath()Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 56
    :goto_0
    if-eqz v1, :cond_0

    .line 58
    :try_start_1
    new-instance v2, Lcom/stericson/RootTools/InternalMethods;

    invoke-direct {v2}, Lcom/stericson/RootTools/InternalMethods;-><init>()V

    .line 59
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v6, "/"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/stericson/RootTools/Runner;->binaryName:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/stericson/RootTools/Runner;->parameter:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, -0x1

    .line 58
    invoke-virtual {v2, v3, v4}, Lcom/stericson/RootTools/InternalMethods;->doExec([Ljava/lang/String;I)V
    :try_end_1
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_1 .. :try_end_1} :catch_1

    .line 62
    :cond_0
    :goto_1
    return-void

    .line 50
    :catch_0
    move-exception v0

    .line 51
    .local v0, "e":Ljava/io/IOException;
    sget-boolean v2, Lcom/stericson/RootTools/RootTools;->debugMode:Z

    if-eqz v2, :cond_1

    .line 52
    const-string v2, "RootTools::Runner"

    const-string v3, "Problem occured while trying to locate private files directory!"

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 54
    :cond_1
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0

    .line 60
    .end local v0    # "e":Ljava/io/IOException;
    :catch_1
    move-exception v2

    goto :goto_1
.end method
