.class public final Lcom/a/a/a/f;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field final a:Lcom/a/a/a/h;

.field final b:[Z

.field c:Z

.field final synthetic d:Lcom/a/a/a/c;

.field private e:Z


# direct methods
.method private constructor <init>(Lcom/a/a/a/c;Lcom/a/a/a/h;)V
    .locals 1

    .prologue
    .line 723
    iput-object p1, p0, Lcom/a/a/a/f;->d:Lcom/a/a/a/c;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 724
    iput-object p2, p0, Lcom/a/a/a/f;->a:Lcom/a/a/a/h;

    .line 725
    iget-boolean v0, p2, Lcom/a/a/a/h;->c:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    iput-object v0, p0, Lcom/a/a/a/f;->b:[Z

    .line 726
    return-void

    .line 725
    :cond_0
    invoke-static {p1}, Lcom/a/a/a/c;->f(Lcom/a/a/a/c;)I

    move-result v0

    new-array v0, v0, [Z

    goto :goto_0
.end method

.method synthetic constructor <init>(Lcom/a/a/a/c;Lcom/a/a/a/h;B)V
    .locals 0

    .prologue
    .line 717
    invoke-direct {p0, p1, p2}, Lcom/a/a/a/f;-><init>(Lcom/a/a/a/c;Lcom/a/a/a/h;)V

    return-void
.end method


# virtual methods
.method public final a(I)Ljava/io/OutputStream;
    .locals 4

    .prologue
    .line 765
    iget-object v2, p0, Lcom/a/a/a/f;->d:Lcom/a/a/a/c;

    monitor-enter v2

    .line 766
    :try_start_0
    iget-object v0, p0, Lcom/a/a/a/f;->a:Lcom/a/a/a/h;

    iget-object v0, v0, Lcom/a/a/a/h;->d:Lcom/a/a/a/f;

    if-eq v0, p0, :cond_0

    .line 767
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    .line 787
    :catchall_0
    move-exception v0

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 769
    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/a/a/a/f;->a:Lcom/a/a/a/h;

    iget-boolean v0, v0, Lcom/a/a/a/h;->c:Z

    if-nez v0, :cond_1

    .line 770
    iget-object v0, p0, Lcom/a/a/a/f;->b:[Z

    const/4 v1, 0x1

    aput-boolean v1, v0, p1

    .line 772
    :cond_1
    iget-object v0, p0, Lcom/a/a/a/f;->a:Lcom/a/a/a/h;

    invoke-virtual {v0, p1}, Lcom/a/a/a/h;->b(I)Ljava/io/File;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v1

    .line 775
    :try_start_2
    new-instance v0, Ljava/io/FileOutputStream;

    invoke-direct {v0, v1}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V
    :try_end_2
    .catch Ljava/io/FileNotFoundException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-object v1, v0

    .line 786
    :goto_0
    :try_start_3
    new-instance v0, Lcom/a/a/a/g;

    const/4 v3, 0x0

    invoke-direct {v0, p0, v1, v3}, Lcom/a/a/a/g;-><init>(Lcom/a/a/a/f;Ljava/io/OutputStream;B)V

    monitor-exit v2

    :goto_1
    return-object v0

    .line 778
    :catch_0
    move-exception v0

    iget-object v0, p0, Lcom/a/a/a/f;->d:Lcom/a/a/a/c;

    invoke-static {v0}, Lcom/a/a/a/c;->g(Lcom/a/a/a/c;)Ljava/io/File;

    move-result-object v0

    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 780
    :try_start_4
    new-instance v0, Ljava/io/FileOutputStream;

    invoke-direct {v0, v1}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V
    :try_end_4
    .catch Ljava/io/FileNotFoundException; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    move-object v1, v0

    .line 784
    goto :goto_0

    .line 783
    :catch_1
    move-exception v0

    :try_start_5
    invoke-static {}, Lcom/a/a/a/c;->a()Ljava/io/OutputStream;

    move-result-object v0

    monitor-exit v2
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_1
.end method

.method public final a()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 806
    iget-boolean v0, p0, Lcom/a/a/a/f;->c:Z

    if-eqz v0, :cond_0

    .line 807
    iget-object v0, p0, Lcom/a/a/a/f;->d:Lcom/a/a/a/c;

    const/4 v1, 0x0

    invoke-static {v0, p0, v1}, Lcom/a/a/a/c;->a(Lcom/a/a/a/c;Lcom/a/a/a/f;Z)V

    .line 808
    iget-object v0, p0, Lcom/a/a/a/f;->d:Lcom/a/a/a/c;

    iget-object v1, p0, Lcom/a/a/a/f;->a:Lcom/a/a/a/h;

    iget-object v1, v1, Lcom/a/a/a/h;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/a/a/a/c;->b(Ljava/lang/String;)Z

    .line 812
    :goto_0
    iput-boolean v2, p0, Lcom/a/a/a/f;->e:Z

    .line 813
    return-void

    .line 810
    :cond_0
    iget-object v0, p0, Lcom/a/a/a/f;->d:Lcom/a/a/a/c;

    invoke-static {v0, p0, v2}, Lcom/a/a/a/c;->a(Lcom/a/a/a/c;Lcom/a/a/a/f;Z)V

    goto :goto_0
.end method

.method public final b()V
    .locals 2

    .prologue
    .line 820
    iget-object v0, p0, Lcom/a/a/a/f;->d:Lcom/a/a/a/c;

    const/4 v1, 0x0

    invoke-static {v0, p0, v1}, Lcom/a/a/a/c;->a(Lcom/a/a/a/c;Lcom/a/a/a/f;Z)V

    .line 821
    return-void
.end method
