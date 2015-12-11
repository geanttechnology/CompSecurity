.class final Lcom/wishabi/flipp/app/cq;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/TextView$OnEditorActionListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/cn;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/cn;)V
    .locals 0

    .prologue
    .line 293
    iput-object p1, p0, Lcom/wishabi/flipp/app/cq;->a:Lcom/wishabi/flipp/app/cn;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onEditorAction(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z
    .locals 1

    .prologue
    .line 297
    iget-object v0, p0, Lcom/wishabi/flipp/app/cq;->a:Lcom/wishabi/flipp/app/cn;

    invoke-static {v0}, Lcom/wishabi/flipp/app/cn;->d(Lcom/wishabi/flipp/app/cn;)V

    .line 298
    const/4 v0, 0x1

    return v0
.end method
