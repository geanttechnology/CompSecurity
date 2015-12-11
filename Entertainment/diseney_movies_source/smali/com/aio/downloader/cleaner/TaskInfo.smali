.class public Lcom/aio/downloader/cleaner/TaskInfo;
.super Ljava/lang/Object;
.source "TaskInfo.java"


# instance fields
.field private icon:Landroid/graphics/drawable/Drawable;

.field private id:I

.field private isCheck:Z

.field private isSystemProcess:Z

.field private memory:I

.field private name:Ljava/lang/String;

.field private packageName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/aio/downloader/cleaner/TaskInfo;->isCheck:Z

    .line 5
    return-void
.end method


# virtual methods
.method public getIcon()Landroid/graphics/drawable/Drawable;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/aio/downloader/cleaner/TaskInfo;->icon:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method public getId()I
    .locals 1

    .prologue
    .line 36
    iget v0, p0, Lcom/aio/downloader/cleaner/TaskInfo;->id:I

    return v0
.end method

.method public getMemory()I
    .locals 1

    .prologue
    .line 60
    iget v0, p0, Lcom/aio/downloader/cleaner/TaskInfo;->memory:I

    return v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/aio/downloader/cleaner/TaskInfo;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getPackageName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/aio/downloader/cleaner/TaskInfo;->packageName:Ljava/lang/String;

    return-object v0
.end method

.method public isCheck()Z
    .locals 1

    .prologue
    .line 44
    iget-boolean v0, p0, Lcom/aio/downloader/cleaner/TaskInfo;->isCheck:Z

    return v0
.end method

.method public isSystemProcess()Z
    .locals 1

    .prologue
    .line 68
    iget-boolean v0, p0, Lcom/aio/downloader/cleaner/TaskInfo;->isSystemProcess:Z

    return v0
.end method

.method public setCheck(Z)V
    .locals 0
    .param p1, "isCheck"    # Z

    .prologue
    .line 48
    iput-boolean p1, p0, Lcom/aio/downloader/cleaner/TaskInfo;->isCheck:Z

    .line 49
    return-void
.end method

.method public setIcon(Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p1, "icon"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 32
    iput-object p1, p0, Lcom/aio/downloader/cleaner/TaskInfo;->icon:Landroid/graphics/drawable/Drawable;

    .line 33
    return-void
.end method

.method public setId(I)V
    .locals 0
    .param p1, "id"    # I

    .prologue
    .line 40
    iput p1, p0, Lcom/aio/downloader/cleaner/TaskInfo;->id:I

    .line 41
    return-void
.end method

.method public setMemory(I)V
    .locals 0
    .param p1, "memory"    # I

    .prologue
    .line 64
    iput p1, p0, Lcom/aio/downloader/cleaner/TaskInfo;->memory:I

    .line 65
    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 24
    iput-object p1, p0, Lcom/aio/downloader/cleaner/TaskInfo;->name:Ljava/lang/String;

    .line 25
    return-void
.end method

.method public setPackageName(Ljava/lang/String;)V
    .locals 0
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    .line 56
    iput-object p1, p0, Lcom/aio/downloader/cleaner/TaskInfo;->packageName:Ljava/lang/String;

    .line 57
    return-void
.end method

.method public setSystemProcess(Z)V
    .locals 0
    .param p1, "isSystemProcess"    # Z

    .prologue
    .line 72
    iput-boolean p1, p0, Lcom/aio/downloader/cleaner/TaskInfo;->isSystemProcess:Z

    .line 73
    return-void
.end method
