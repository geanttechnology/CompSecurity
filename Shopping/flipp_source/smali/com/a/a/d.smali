.class final Lcom/a/a/d;
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
.field final synthetic a:Lcom/a/a/c;


# direct methods
.method constructor <init>(Lcom/a/a/c;)V
    .locals 0

    .prologue
    .line 86
    iput-object p1, p0, Lcom/a/a/d;->a:Lcom/a/a/c;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private a()Ljava/lang/Void;
    .locals 14

    .prologue
    const/4 v7, 0x2

    const/4 v3, 0x0

    .line 88
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4, v7}, Ljava/util/ArrayList;-><init>(I)V

    .line 90
    iget-object v5, p0, Lcom/a/a/d;->a:Lcom/a/a/c;

    monitor-enter v5

    .line 91
    :try_start_0
    iget-object v0, p0, Lcom/a/a/d;->a:Lcom/a/a/c;

    invoke-static {v0}, Lcom/a/a/c;->a(Lcom/a/a/c;)Ljava/util/LinkedList;

    move-result-object v0

    iget-object v1, p0, Lcom/a/a/d;->a:Lcom/a/a/c;

    invoke-static {v1}, Lcom/a/a/c;->a(Lcom/a/a/c;)Ljava/util/LinkedList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/LinkedList;->size()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/util/LinkedList;->listIterator(I)Ljava/util/ListIterator;

    move-result-object v6

    move v1, v3

    .line 92
    :goto_0
    invoke-interface {v6}, Ljava/util/ListIterator;->hasPrevious()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 93
    invoke-interface {v6}, Ljava/util/ListIterator;->previous()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/a/a/b;

    .line 94
    invoke-virtual {v0}, Lcom/a/a/b;->a()Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/a/a/d;->a:Lcom/a/a/c;

    invoke-static {v2}, Lcom/a/a/c;->b(Lcom/a/a/c;)J

    move-result-wide v8

    invoke-virtual {v0}, Lcom/a/a/b;->c()Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v10

    invoke-virtual {v0}, Lcom/a/a/b;->d()J

    move-result-wide v12

    sub-long/2addr v10, v12

    cmp-long v2, v10, v8

    if-lez v2, :cond_2

    const/4 v2, 0x1

    :goto_1
    if-eqz v2, :cond_3

    .line 95
    :cond_0
    invoke-interface {v6}, Ljava/util/ListIterator;->remove()V

    .line 96
    invoke-interface {v4, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 97
    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v0

    if-ne v0, v7, :cond_7

    .line 103
    :cond_1
    iget-object v0, p0, Lcom/a/a/d;->a:Lcom/a/a/c;

    invoke-static {v0}, Lcom/a/a/c;->a(Lcom/a/a/c;)Ljava/util/LinkedList;

    move-result-object v0

    iget-object v2, p0, Lcom/a/a/d;->a:Lcom/a/a/c;

    invoke-static {v2}, Lcom/a/a/c;->a(Lcom/a/a/c;)Ljava/util/LinkedList;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/LinkedList;->size()I

    move-result v2

    invoke-virtual {v0, v2}, Ljava/util/LinkedList;->listIterator(I)Ljava/util/ListIterator;

    move-result-object v2

    .line 104
    :goto_2
    invoke-interface {v2}, Ljava/util/ListIterator;->hasPrevious()Z

    move-result v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/a/a/d;->a:Lcom/a/a/c;

    invoke-static {v0}, Lcom/a/a/c;->c(Lcom/a/a/c;)I

    move-result v0

    if-le v1, v0, :cond_4

    .line 105
    invoke-interface {v2}, Ljava/util/ListIterator;->previous()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/a/a/b;

    .line 106
    invoke-virtual {v0}, Lcom/a/a/b;->c()Z

    move-result v3

    if-eqz v3, :cond_6

    .line 107
    invoke-interface {v4, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 108
    invoke-interface {v2}, Ljava/util/ListIterator;->remove()V

    .line 109
    add-int/lit8 v0, v1, -0x1

    :goto_3
    move v1, v0

    .line 111
    goto :goto_2

    :cond_2
    move v2, v3

    .line 94
    goto :goto_1

    .line 98
    :cond_3
    invoke-virtual {v0}, Lcom/a/a/b;->c()Z

    move-result v0

    if-eqz v0, :cond_7

    .line 99
    add-int/lit8 v0, v1, 0x1

    :goto_4
    move v1, v0

    .line 101
    goto :goto_0

    .line 112
    :cond_4
    monitor-exit v5
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 113
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_5
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/a/a/b;

    .line 114
    invoke-static {v0}, Lcom/a/a/a/u;->a(Ljava/io/Closeable;)V

    goto :goto_5

    .line 112
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v5
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0

    .line 116
    :cond_5
    const/4 v0, 0x0

    return-object v0

    :cond_6
    move v0, v1

    goto :goto_3

    :cond_7
    move v0, v1

    goto :goto_4
.end method


# virtual methods
.method public final synthetic call()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 86
    invoke-direct {p0}, Lcom/a/a/d;->a()Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method
