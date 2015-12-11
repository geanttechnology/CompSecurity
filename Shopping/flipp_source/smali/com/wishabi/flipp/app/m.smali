.class public final Lcom/wishabi/flipp/app/m;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Landroid/util/Pair",
        "<",
        "Ljava/lang/Integer;",
        "Lcom/wishabi/flipp/content/c;",
        ">;>;"
    }
.end annotation


# instance fields
.field private a:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/wishabi/flipp/content/o;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/util/HashMap;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/wishabi/flipp/content/o;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/wishabi/flipp/app/m;->a:Ljava/util/HashMap;

    .line 21
    return-void
.end method

.method private declared-synchronized a(Landroid/util/Pair;Landroid/util/Pair;)I
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/util/Pair",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/wishabi/flipp/content/c;",
            ">;",
            "Landroid/util/Pair",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/wishabi/flipp/content/c;",
            ">;)I"
        }
    .end annotation

    .prologue
    const/4 v8, 0x0

    const/4 v6, 0x1

    const/4 v7, -0x1

    .line 31
    monitor-enter p0

    :try_start_0
    iget-object v0, p1, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v0, Ljava/lang/Integer;

    .line 32
    iget-object v1, p2, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v1, Ljava/lang/Integer;

    .line 33
    iget-object v2, p1, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v2, Lcom/wishabi/flipp/content/c;

    .line 34
    iget-object v3, p2, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v3, Lcom/wishabi/flipp/content/c;

    .line 37
    iget-object v4, p0, Lcom/wishabi/flipp/app/m;->a:Ljava/util/HashMap;

    if-nez v4, :cond_0

    .line 38
    invoke-virtual {v0, v1}, Ljava/lang/Integer;->compareTo(Ljava/lang/Integer;)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    .line 88
    :goto_0
    monitor-exit p0

    return v0

    .line 40
    :cond_0
    :try_start_1
    iget-object v4, p0, Lcom/wishabi/flipp/app/m;->a:Ljava/util/HashMap;

    iget v5, v2, Lcom/wishabi/flipp/content/c;->a:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/ArrayList;

    .line 42
    iget-object v5, p0, Lcom/wishabi/flipp/app/m;->a:Ljava/util/HashMap;

    iget v9, v3, Lcom/wishabi/flipp/content/c;->a:I

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v5, v9}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/ArrayList;

    .line 46
    if-eqz v4, :cond_b

    invoke-virtual {v4}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v9

    if-nez v9, :cond_b

    .line 47
    const/4 v9, 0x0

    invoke-virtual {v4, v9}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/wishabi/flipp/content/o;

    move-object v9, v4

    .line 50
    :goto_1
    if-eqz v5, :cond_a

    invoke-virtual {v5}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_a

    .line 51
    const/4 v4, 0x0

    invoke-virtual {v5, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/wishabi/flipp/content/o;

    .line 53
    :goto_2
    if-nez v9, :cond_1

    if-nez v4, :cond_1

    .line 54
    invoke-virtual {v0, v1}, Ljava/lang/Integer;->compareTo(Ljava/lang/Integer;)I

    move-result v0

    goto :goto_0

    .line 56
    :cond_1
    if-nez v9, :cond_2

    move v0, v6

    .line 57
    goto :goto_0

    .line 59
    :cond_2
    if-nez v4, :cond_3

    move v0, v7

    .line 60
    goto :goto_0

    .line 63
    :cond_3
    iget v2, v2, Lcom/wishabi/flipp/content/c;->o:I

    .line 64
    iget v3, v3, Lcom/wishabi/flipp/content/c;->o:I

    .line 66
    if-ge v2, v3, :cond_4

    move v0, v7

    .line 67
    goto :goto_0

    .line 69
    :cond_4
    if-ge v3, v2, :cond_5

    move v0, v6

    .line 70
    goto :goto_0

    .line 73
    :cond_5
    iget-object v2, v9, Lcom/wishabi/flipp/content/o;->k:Ljava/lang/Float;

    .line 74
    iget-object v3, v4, Lcom/wishabi/flipp/content/o;->k:Ljava/lang/Float;

    .line 76
    if-nez v2, :cond_6

    if-nez v3, :cond_6

    .line 77
    invoke-virtual {v0, v1}, Ljava/lang/Integer;->compareTo(Ljava/lang/Integer;)I

    move-result v0

    goto :goto_0

    .line 79
    :cond_6
    if-nez v2, :cond_7

    move v0, v6

    .line 80
    goto :goto_0

    .line 82
    :cond_7
    if-nez v3, :cond_8

    move v0, v7

    .line 83
    goto :goto_0

    .line 85
    :cond_8
    invoke-virtual {v2, v3}, Ljava/lang/Float;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_9

    .line 86
    invoke-virtual {v0, v1}, Ljava/lang/Integer;->compareTo(Ljava/lang/Integer;)I

    move-result v0

    goto :goto_0

    .line 88
    :cond_9
    invoke-virtual {v3, v2}, Ljava/lang/Float;->compareTo(Ljava/lang/Float;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v0

    goto :goto_0

    .line 31
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    :cond_a
    move-object v4, v8

    goto :goto_2

    :cond_b
    move-object v9, v8

    goto :goto_1
.end method


# virtual methods
.method public final synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 14
    check-cast p1, Landroid/util/Pair;

    check-cast p2, Landroid/util/Pair;

    invoke-direct {p0, p1, p2}, Lcom/wishabi/flipp/app/m;->a(Landroid/util/Pair;Landroid/util/Pair;)I

    move-result v0

    return v0
.end method
