.class public final Luk/co/senab/actionbarpulltorefresh/library/b;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public a:Luk/co/senab/actionbarpulltorefresh/library/h;

.field public b:Luk/co/senab/actionbarpulltorefresh/library/a/b;

.field public c:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Class;",
            "Luk/co/senab/actionbarpulltorefresh/library/b/c;",
            ">;"
        }
    .end annotation
.end field

.field private final d:Landroid/app/Activity;

.field private e:[I

.field private f:[Landroid/view/View;

.field private g:Landroid/view/ViewGroup;


# direct methods
.method private constructor <init>(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 46
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 47
    iput-object p1, p0, Luk/co/senab/actionbarpulltorefresh/library/b;->d:Landroid/app/Activity;

    .line 48
    return-void
.end method

.method synthetic constructor <init>(Landroid/app/Activity;B)V
    .locals 0

    .prologue
    .line 37
    invoke-direct {p0, p1}, Luk/co/senab/actionbarpulltorefresh/library/b;-><init>(Landroid/app/Activity;)V

    return-void
.end method


# virtual methods
.method public final varargs a([Landroid/view/View;)Luk/co/senab/actionbarpulltorefresh/library/b;
    .locals 1

    .prologue
    .line 68
    iput-object p1, p0, Luk/co/senab/actionbarpulltorefresh/library/b;->f:[Landroid/view/View;

    .line 69
    const/4 v0, 0x0

    iput-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/b;->e:[I

    .line 70
    return-object p0
.end method

.method public final a(Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;)V
    .locals 7

    .prologue
    const/4 v4, -0x1

    const/4 v0, 0x0

    .line 92
    iget-object v1, p0, Luk/co/senab/actionbarpulltorefresh/library/b;->d:Landroid/app/Activity;

    iget-object v2, p0, Luk/co/senab/actionbarpulltorefresh/library/b;->a:Luk/co/senab/actionbarpulltorefresh/library/h;

    invoke-static {v1, v2}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->a(Landroid/app/Activity;Luk/co/senab/actionbarpulltorefresh/library/h;)Luk/co/senab/actionbarpulltorefresh/library/j;

    move-result-object v3

    .line 94
    iget-object v1, p0, Luk/co/senab/actionbarpulltorefresh/library/b;->b:Luk/co/senab/actionbarpulltorefresh/library/a/b;

    iput-object v1, v3, Luk/co/senab/actionbarpulltorefresh/library/j;->b:Luk/co/senab/actionbarpulltorefresh/library/a/b;

    .line 96
    iget-object v1, p0, Luk/co/senab/actionbarpulltorefresh/library/b;->g:Landroid/view/ViewGroup;

    if-eqz v1, :cond_1

    .line 97
    iget-object v2, p0, Luk/co/senab/actionbarpulltorefresh/library/b;->g:Landroid/view/ViewGroup;

    invoke-virtual {v2, v0}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    :goto_0
    if-eqz v1, :cond_0

    invoke-virtual {v2, v0}, Landroid/view/ViewGroup;->removeViewAt(I)V

    invoke-virtual {p1, v1}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->addView(Landroid/view/View;)V

    invoke-virtual {v2, v0}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    goto :goto_0

    :cond_0
    invoke-virtual {v2, p1, v4, v4}, Landroid/view/ViewGroup;->addView(Landroid/view/View;II)V

    .line 100
    :cond_1
    invoke-virtual {p1, v3}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->setPullToRefreshAttacher(Luk/co/senab/actionbarpulltorefresh/library/j;)V

    .line 103
    iget-object v1, p0, Luk/co/senab/actionbarpulltorefresh/library/b;->e:[I

    if-eqz v1, :cond_3

    .line 104
    iget-object v1, p0, Luk/co/senab/actionbarpulltorefresh/library/b;->e:[I

    array-length v2, v1

    :goto_1
    if-ge v0, v2, :cond_6

    aget v4, v1, v0

    invoke-virtual {p1, v4}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    if-eqz v4, :cond_2

    aget v4, v1, v0

    invoke-virtual {p1, v4}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    invoke-virtual {p1, v4}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->a(Landroid/view/View;)V

    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 105
    :cond_3
    iget-object v1, p0, Luk/co/senab/actionbarpulltorefresh/library/b;->f:[Landroid/view/View;

    if-eqz v1, :cond_5

    .line 106
    iget-object v1, p0, Luk/co/senab/actionbarpulltorefresh/library/b;->f:[Landroid/view/View;

    array-length v2, v1

    :goto_2
    if-ge v0, v2, :cond_6

    aget-object v4, v1, v0

    if-eqz v4, :cond_4

    aget-object v4, v1, v0

    invoke-virtual {p1, v4}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->a(Landroid/view/View;)V

    :cond_4
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 108
    :cond_5
    invoke-virtual {p1}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->a()V

    invoke-virtual {p1}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->getChildCount()I

    move-result v1

    :goto_3
    if-ge v0, v1, :cond_6

    invoke-virtual {p1, v0}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {p1, v2}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->a(Landroid/view/View;)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_3

    .line 112
    :cond_6
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/b;->c:Ljava/util/HashMap;

    if-eqz v0, :cond_9

    .line 113
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/b;->c:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v0

    .line 114
    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_7
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_9

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 115
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Class;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    move-object v2, v0

    check-cast v2, Luk/co/senab/actionbarpulltorefresh/library/b/c;

    iget-object v0, v3, Luk/co/senab/actionbarpulltorefresh/library/j;->m:Ljava/util/WeakHashMap;

    invoke-virtual {v0}, Ljava/util/WeakHashMap;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_8
    :goto_4
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_7

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    invoke-virtual {v1, v0}, Ljava/lang/Class;->isInstance(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_8

    iget-object v6, v3, Luk/co/senab/actionbarpulltorefresh/library/j;->m:Ljava/util/WeakHashMap;

    invoke-virtual {v6, v0, v2}, Ljava/util/WeakHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_4

    .line 118
    :cond_9
    return-void
.end method
