.class public Lcom/penthera/virtuososdk/manager/FileManager;
.super Ljava/lang/Object;
.source "FileManager.java"


# static fields
.field private static LOG_TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const-class v0, Lcom/penthera/virtuososdk/manager/FileManager;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/penthera/virtuososdk/manager/FileManager;->LOG_TAG:Ljava/lang/String;

    .line 14
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public remove(Ljava/lang/String;)V
    .locals 2
    .param p1, "filename"    # Ljava/lang/String;

    .prologue
    .line 20
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    aput-object p1, v0, v1

    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/manager/FileManager;->remove([Ljava/lang/String;)V

    .line 21
    return-void
.end method

.method public remove([Ljava/lang/String;)V
    .locals 3
    .param p1, "filenames"    # [Ljava/lang/String;

    .prologue
    .line 24
    sget-object v1, Lcom/penthera/virtuososdk/manager/FileManager;->LOG_TAG:Ljava/lang/String;

    const-string v2, "Removing files from disk: "

    invoke-static {v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 26
    new-instance v0, Lcom/penthera/virtuososdk/manager/FileDeletionThread;

    invoke-direct {v0}, Lcom/penthera/virtuososdk/manager/FileDeletionThread;-><init>()V

    .line 27
    .local v0, "thread":Lcom/penthera/virtuososdk/manager/FileDeletionThread;
    invoke-virtual {v0, p1}, Lcom/penthera/virtuososdk/manager/FileDeletionThread;->setFilesToDelete([Ljava/lang/String;)V

    .line 28
    invoke-virtual {v0}, Lcom/penthera/virtuososdk/manager/FileDeletionThread;->start()V

    .line 29
    return-void
.end method
