.class final Lcom/wishabi/flipp/app/em;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/SearchFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/SearchFragment;)V
    .locals 0

    .prologue
    .line 372
    iput-object p1, p0, Lcom/wishabi/flipp/app/em;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 1

    .prologue
    .line 375
    iget-object v0, p0, Lcom/wishabi/flipp/app/em;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->j(Lcom/wishabi/flipp/app/SearchFragment;)V

    .line 376
    const/4 v0, 0x0

    return v0
.end method
