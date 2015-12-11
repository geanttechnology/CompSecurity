.class final Landroid/support/v4/app/av;
.super Landroid/transition/Transition$EpicenterCallback;
.source "SourceFile"


# instance fields
.field final synthetic a:Landroid/support/v4/app/ax;

.field private b:Landroid/graphics/Rect;


# direct methods
.method constructor <init>(Landroid/support/v4/app/ax;)V
    .locals 0

    .prologue
    .line 207
    iput-object p1, p0, Landroid/support/v4/app/av;->a:Landroid/support/v4/app/ax;

    invoke-direct {p0}, Landroid/transition/Transition$EpicenterCallback;-><init>()V

    return-void
.end method


# virtual methods
.method public final onGetEpicenter(Landroid/transition/Transition;)Landroid/graphics/Rect;
    .locals 1

    .prologue
    .line 212
    iget-object v0, p0, Landroid/support/v4/app/av;->b:Landroid/graphics/Rect;

    if-nez v0, :cond_0

    iget-object v0, p0, Landroid/support/v4/app/av;->a:Landroid/support/v4/app/ax;

    iget-object v0, v0, Landroid/support/v4/app/ax;->a:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 213
    iget-object v0, p0, Landroid/support/v4/app/av;->a:Landroid/support/v4/app/ax;

    iget-object v0, v0, Landroid/support/v4/app/ax;->a:Landroid/view/View;

    invoke-static {v0}, Landroid/support/v4/app/as;->b(Landroid/view/View;)Landroid/graphics/Rect;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v4/app/av;->b:Landroid/graphics/Rect;

    .line 215
    :cond_0
    iget-object v0, p0, Landroid/support/v4/app/av;->b:Landroid/graphics/Rect;

    return-object v0
.end method
