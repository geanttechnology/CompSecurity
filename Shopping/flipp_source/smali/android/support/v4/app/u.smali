.class final Landroid/support/v4/app/u;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/ViewTreeObserver$OnPreDrawListener;


# instance fields
.field final synthetic a:Landroid/view/View;

.field final synthetic b:Landroid/support/v4/app/w;

.field final synthetic c:I

.field final synthetic d:Ljava/lang/Object;

.field final synthetic e:Landroid/support/v4/app/r;


# direct methods
.method constructor <init>(Landroid/support/v4/app/r;Landroid/view/View;Landroid/support/v4/app/w;ILjava/lang/Object;)V
    .locals 0

    .prologue
    .line 1365
    iput-object p1, p0, Landroid/support/v4/app/u;->e:Landroid/support/v4/app/r;

    iput-object p2, p0, Landroid/support/v4/app/u;->a:Landroid/view/View;

    iput-object p3, p0, Landroid/support/v4/app/u;->b:Landroid/support/v4/app/w;

    iput p4, p0, Landroid/support/v4/app/u;->c:I

    iput-object p5, p0, Landroid/support/v4/app/u;->d:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onPreDraw()Z
    .locals 4

    .prologue
    .line 1367
    iget-object v0, p0, Landroid/support/v4/app/u;->a:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/ViewTreeObserver;->removeOnPreDrawListener(Landroid/view/ViewTreeObserver$OnPreDrawListener;)V

    .line 1368
    iget-object v0, p0, Landroid/support/v4/app/u;->e:Landroid/support/v4/app/r;

    iget-object v1, p0, Landroid/support/v4/app/u;->b:Landroid/support/v4/app/w;

    iget v2, p0, Landroid/support/v4/app/u;->c:I

    iget-object v3, p0, Landroid/support/v4/app/u;->d:Ljava/lang/Object;

    invoke-static {v0, v1, v2, v3}, Landroid/support/v4/app/r;->a(Landroid/support/v4/app/r;Landroid/support/v4/app/w;ILjava/lang/Object;)V

    .line 1369
    const/4 v0, 0x1

    return v0
.end method
