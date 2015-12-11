.class final Lk;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field final a:Ljava/io/File;

.field final b:Ljava/io/File;

.field final c:Ljava/io/File;

.field final d:Ljava/io/File;


# direct methods
.method private constructor <init>(Landroid/content/Context;J)V
    .locals 4

    .prologue
    .line 240
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 241
    const-string v0, "com.appdynamics.eumagent.runtime"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getDir(Ljava/lang/String;I)Ljava/io/File;

    move-result-object v0

    .line 242
    new-instance v1, Ljava/io/File;

    const-string v2, "infopoints"

    invoke-direct {v1, v0, v2}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    iput-object v1, p0, Lk;->a:Ljava/io/File;

    .line 243
    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Lk;->a:Ljava/io/File;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p2, p3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    iput-object v0, p0, Lk;->b:Ljava/io/File;

    .line 244
    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Lk;->b:Ljava/io/File;

    const-string v2, "cache"

    invoke-direct {v0, v1, v2}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    iput-object v0, p0, Lk;->d:Ljava/io/File;

    .line 245
    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Lk;->b:Ljava/io/File;

    const-string v2, "classes.apk"

    invoke-direct {v0, v1, v2}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    iput-object v0, p0, Lk;->c:Ljava/io/File;

    .line 246
    return-void
.end method

.method synthetic constructor <init>(Landroid/content/Context;JB)V
    .locals 0

    .prologue
    .line 234
    invoke-direct {p0, p1, p2, p3}, Lk;-><init>(Landroid/content/Context;J)V

    return-void
.end method
