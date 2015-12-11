.class final Lcom/wishabi/flipp/widget/df;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/widget/db;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/widget/db;)V
    .locals 0

    .prologue
    .line 147
    iput-object p1, p0, Lcom/wishabi/flipp/widget/df;->a:Lcom/wishabi/flipp/widget/db;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 1

    .prologue
    .line 150
    iget-object v0, p0, Lcom/wishabi/flipp/widget/df;->a:Lcom/wishabi/flipp/widget/db;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/db;->c(Lcom/wishabi/flipp/widget/db;)Landroid/view/GestureDetector;

    move-result-object v0

    invoke-virtual {v0, p2}, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    return v0
.end method
