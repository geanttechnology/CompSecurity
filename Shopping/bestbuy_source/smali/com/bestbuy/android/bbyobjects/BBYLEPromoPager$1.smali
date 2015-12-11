.class Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;->a(Landroid/content/Context;Ljava/util/List;Landroid/widget/ScrollView;)V
.end annotation


# instance fields
.field final synthetic a:Landroid/widget/ScrollView;

.field final synthetic b:Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;Landroid/widget/ScrollView;)V
    .locals 0

    .prologue
    .line 52
    iput-object p1, p0, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager$1;->b:Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;

    iput-object p2, p0, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager$1;->a:Landroid/widget/ScrollView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 2

    .prologue
    .line 54
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager$1;->a:Landroid/widget/ScrollView;

    if-eqz v0, :cond_0

    .line 55
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager$1;->a:Landroid/widget/ScrollView;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/ScrollView;->requestDisallowInterceptTouchEvent(Z)V

    .line 57
    :cond_0
    const/4 v0, 0x0

    return v0
.end method
