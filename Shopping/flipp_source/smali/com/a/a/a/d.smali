.class final Lcom/a/a/a/d;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/concurrent/Callable",
        "<",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/a/a/a/c;


# direct methods
.method constructor <init>(Lcom/a/a/a/c;)V
    .locals 0

    .prologue
    .line 164
    iput-object p1, p0, Lcom/a/a/a/d;->a:Lcom/a/a/a/c;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private a()Ljava/lang/Void;
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 166
    iget-object v1, p0, Lcom/a/a/a/d;->a:Lcom/a/a/a/c;

    monitor-enter v1

    .line 167
    :try_start_0
    iget-object v0, p0, Lcom/a/a/a/d;->a:Lcom/a/a/a/c;

    invoke-static {v0}, Lcom/a/a/a/c;->a(Lcom/a/a/a/c;)Ljava/io/Writer;

    move-result-object v0

    if-nez v0, :cond_0

    .line 168
    monitor-exit v1

    .line 176
    :goto_0
    return-object v2

    .line 170
    :cond_0
    iget-object v0, p0, Lcom/a/a/a/d;->a:Lcom/a/a/a/c;

    invoke-static {v0}, Lcom/a/a/a/c;->b(Lcom/a/a/a/c;)V

    .line 171
    iget-object v0, p0, Lcom/a/a/a/d;->a:Lcom/a/a/a/c;

    invoke-static {v0}, Lcom/a/a/a/c;->c(Lcom/a/a/a/c;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 172
    iget-object v0, p0, Lcom/a/a/a/d;->a:Lcom/a/a/a/c;

    invoke-static {v0}, Lcom/a/a/a/c;->d(Lcom/a/a/a/c;)V

    .line 173
    iget-object v0, p0, Lcom/a/a/a/d;->a:Lcom/a/a/a/c;

    invoke-static {v0}, Lcom/a/a/a/c;->e(Lcom/a/a/a/c;)I

    .line 175
    :cond_1
    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method


# virtual methods
.method public final synthetic call()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 164
    invoke-direct {p0}, Lcom/a/a/a/d;->a()Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method
