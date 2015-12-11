.class public final Lcom/wishabi/flipp/widget/cy;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Luk/co/senab/actionbarpulltorefresh/library/b/c;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Landroid/view/View;F)Z
    .locals 1

    .prologue
    .line 13
    check-cast p1, Lcom/wishabi/flipp/widget/PullableRecyclerView;

    .line 14
    invoke-virtual {p1}, Lcom/wishabi/flipp/widget/PullableRecyclerView;->j()Z

    move-result v0

    return v0
.end method
