.class Lcom/penthera/virtuososdk/manager/FileDeletionThread;
.super Ljava/lang/Thread;
.source "FileManager.java"


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private filesToDelete:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 33
    const-class v0, Lcom/penthera/virtuososdk/manager/FileDeletionThread;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/penthera/virtuososdk/manager/FileDeletionThread;->LOG_TAG:Ljava/lang/String;

    .line 32
    return-void
.end method

.method constructor <init>()V
    .locals 1

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 35
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/penthera/virtuososdk/manager/FileDeletionThread;->filesToDelete:[Ljava/lang/String;

    .line 32
    return-void
.end method

.method private deleteDirectoryContent(Ljava/io/File;)V
    .locals 6
    .param p1, "file"    # Ljava/io/File;

    .prologue
    .line 93
    invoke-virtual {p1}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v0

    .line 94
    .local v0, "files":[Ljava/io/File;
    if-nez v0, :cond_1

    .line 109
    :cond_0
    return-void

    .line 97
    :cond_1
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v3, v0

    if-ge v1, v3, :cond_0

    .line 98
    aget-object v3, v0, v1

    invoke-virtual {v3}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v2

    .line 99
    .local v2, "path":Ljava/lang/String;
    aget-object v3, v0, v1

    invoke-virtual {v3}, Ljava/io/File;->isDirectory()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 100
    aget-object v3, v0, v1

    invoke-direct {p0, v3}, Lcom/penthera/virtuososdk/manager/FileDeletionThread;->deleteDirectoryContent(Ljava/io/File;)V

    .line 103
    :cond_2
    aget-object v3, v0, v1

    invoke-virtual {v3}, Ljava/io/File;->delete()Z

    move-result v3

    if-nez v3, :cond_3

    .line 104
    sget-object v3, Lcom/penthera/virtuososdk/manager/FileDeletionThread;->LOG_TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "File deletion failed for: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 97
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 106
    :cond_3
    sget-object v3, Lcom/penthera/virtuososdk/manager/FileDeletionThread;->LOG_TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "File deletion succeeded for: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method


# virtual methods
.method delete(Ljava/io/File;Ljava/lang/String;)V
    .locals 3
    .param p1, "file"    # Ljava/io/File;
    .param p2, "passedPath"    # Ljava/lang/String;

    .prologue
    .line 74
    invoke-virtual {p1}, Ljava/io/File;->canWrite()Z

    move-result v0

    if-nez v0, :cond_0

    .line 75
    sget-object v0, Lcom/penthera/virtuososdk/manager/FileDeletionThread;->LOG_TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "File deletion failed for: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " not writable"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 90
    :goto_0
    return-void

    .line 78
    :cond_0
    const-string v0, "/"

    invoke-virtual {v0, p2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 79
    sget-object v0, Lcom/penthera/virtuososdk/manager/FileDeletionThread;->LOG_TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "File deletion failed for: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " cannot delete root"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 82
    :cond_1
    invoke-virtual {p1}, Ljava/io/File;->isDirectory()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 83
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/manager/FileDeletionThread;->deleteDirectoryContent(Ljava/io/File;)V

    .line 85
    :cond_2
    invoke-virtual {p1}, Ljava/io/File;->delete()Z

    move-result v0

    if-nez v0, :cond_3

    .line 86
    sget-object v0, Lcom/penthera/virtuososdk/manager/FileDeletionThread;->LOG_TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "File deletion failed for: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 88
    :cond_3
    sget-object v0, Lcom/penthera/virtuososdk/manager/FileDeletionThread;->LOG_TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "File deletion succeeded for: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public run()V
    .locals 5

    .prologue
    .line 43
    sget-object v2, Lcom/penthera/virtuososdk/manager/FileDeletionThread;->LOG_TAG:Ljava/lang/String;

    const-string v3, "FileDeletionThread: run()"

    invoke-static {v2, v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 45
    iget-object v2, p0, Lcom/penthera/virtuososdk/manager/FileDeletionThread;->filesToDelete:[Ljava/lang/String;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/penthera/virtuososdk/manager/FileDeletionThread;->filesToDelete:[Ljava/lang/String;

    array-length v2, v2

    if-nez v2, :cond_1

    .line 46
    :cond_0
    sget-object v2, Lcom/penthera/virtuososdk/manager/FileDeletionThread;->LOG_TAG:Ljava/lang/String;

    const-string v3, "File to delete not set or empty.  Returning"

    invoke-static {v2, v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 71
    :goto_0
    return-void

    .line 49
    :cond_1
    const/4 v1, 0x0

    .local v1, "idx":I
    :goto_1
    iget-object v2, p0, Lcom/penthera/virtuososdk/manager/FileDeletionThread;->filesToDelete:[Ljava/lang/String;

    array-length v2, v2

    if-lt v1, v2, :cond_2

    .line 70
    sget-object v2, Lcom/penthera/virtuososdk/manager/FileDeletionThread;->LOG_TAG:Ljava/lang/String;

    const-string v3, "FileDeletionThread: finished..."

    invoke-static {v2, v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 51
    :cond_2
    iget-object v2, p0, Lcom/penthera/virtuososdk/manager/FileDeletionThread;->filesToDelete:[Ljava/lang/String;

    aget-object v2, v2, v1

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 49
    :goto_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 53
    :cond_3
    sget-object v2, Lcom/penthera/virtuososdk/manager/FileDeletionThread;->LOG_TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "FileDeletionThread: attempting deleted on "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lcom/penthera/virtuososdk/manager/FileDeletionThread;->filesToDelete:[Ljava/lang/String;

    aget-object v4, v4, v1

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 55
    new-instance v0, Ljava/io/File;

    iget-object v2, p0, Lcom/penthera/virtuososdk/manager/FileDeletionThread;->filesToDelete:[Ljava/lang/String;

    aget-object v2, v2, v1

    invoke-direct {v0, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 56
    .local v0, "file":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v2

    if-nez v2, :cond_4

    .line 57
    sget-object v2, Lcom/penthera/virtuososdk/manager/FileDeletionThread;->LOG_TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "File deletion failed because it doesn\'t exist: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lcom/penthera/virtuososdk/manager/FileDeletionThread;->filesToDelete:[Ljava/lang/String;

    aget-object v4, v4, v1

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2

    .line 62
    :cond_4
    iget-object v2, p0, Lcom/penthera/virtuososdk/manager/FileDeletionThread;->filesToDelete:[Ljava/lang/String;

    aget-object v2, v2, v1

    const-string v3, "virtuoso/media"

    invoke-virtual {v2, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_5

    .line 63
    sget-object v2, Lcom/penthera/virtuososdk/manager/FileDeletionThread;->LOG_TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "Not an SDK file. File deletion failed for "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lcom/penthera/virtuososdk/manager/FileDeletionThread;->filesToDelete:[Ljava/lang/String;

    aget-object v4, v4, v1

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2

    .line 67
    :cond_5
    iget-object v2, p0, Lcom/penthera/virtuososdk/manager/FileDeletionThread;->filesToDelete:[Ljava/lang/String;

    aget-object v2, v2, v1

    invoke-virtual {p0, v0, v2}, Lcom/penthera/virtuososdk/manager/FileDeletionThread;->delete(Ljava/io/File;Ljava/lang/String;)V

    goto :goto_2
.end method

.method public setFilesToDelete([Ljava/lang/String;)V
    .locals 0
    .param p1, "file"    # [Ljava/lang/String;

    .prologue
    .line 38
    iput-object p1, p0, Lcom/penthera/virtuososdk/manager/FileDeletionThread;->filesToDelete:[Ljava/lang/String;

    .line 39
    return-void
.end method
