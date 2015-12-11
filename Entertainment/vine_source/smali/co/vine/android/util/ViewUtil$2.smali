.class final Lco/vine/android/util/ViewUtil$2;
.super Ljava/lang/Object;
.source "ViewUtil.java"

# interfaces
.implements Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/util/ViewUtil;->setActionBarHeightWhenReady(Landroid/support/v7/app/ActionBarActivity;Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$actionBarActivity:Landroid/support/v7/app/ActionBarActivity;

.field final synthetic val$observer:Landroid/view/ViewTreeObserver;

.field final synthetic val$viewToSet:Landroid/view/View;


# direct methods
.method constructor <init>(Landroid/support/v7/app/ActionBarActivity;Landroid/view/View;Landroid/view/ViewTreeObserver;)V
    .locals 0

    .prologue
    .line 105
    iput-object p1, p0, Lco/vine/android/util/ViewUtil$2;->val$actionBarActivity:Landroid/support/v7/app/ActionBarActivity;

    iput-object p2, p0, Lco/vine/android/util/ViewUtil$2;->val$viewToSet:Landroid/view/View;

    iput-object p3, p0, Lco/vine/android/util/ViewUtil$2;->val$observer:Landroid/view/ViewTreeObserver;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onGlobalLayout()V
    .locals 4

    .prologue
    .line 108
    iget-object v2, p0, Lco/vine/android/util/ViewUtil$2;->val$actionBarActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-virtual {v2}, Landroid/support/v7/app/ActionBarActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    .line 109
    .local v0, "ab":Landroid/support/v7/app/ActionBar;
    if-eqz v0, :cond_0

    .line 110
    invoke-virtual {v0}, Landroid/support/v7/app/ActionBar;->getHeight()I

    move-result v1

    .line 111
    .local v1, "height":I
    if-lez v1, :cond_0

    .line 112
    iget-object v2, p0, Lco/vine/android/util/ViewUtil$2;->val$viewToSet:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    iput v1, v2, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 113
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0x10

    if-ge v2, v3, :cond_1

    .line 114
    iget-object v2, p0, Lco/vine/android/util/ViewUtil$2;->val$observer:Landroid/view/ViewTreeObserver;

    invoke-virtual {v2, p0}, Landroid/view/ViewTreeObserver;->removeGlobalOnLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 120
    .end local v1    # "height":I
    :cond_0
    :goto_0
    return-void

    .line 116
    .restart local v1    # "height":I
    :cond_1
    iget-object v2, p0, Lco/vine/android/util/ViewUtil$2;->val$observer:Landroid/view/ViewTreeObserver;

    invoke-virtual {v2, p0}, Landroid/view/ViewTreeObserver;->removeOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    goto :goto_0
.end method
