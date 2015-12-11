.class final Lcom/wishabi/flipp/app/cr;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/cn;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/cn;)V
    .locals 0

    .prologue
    .line 304
    iput-object p1, p0, Lcom/wishabi/flipp/app/cr;->a:Lcom/wishabi/flipp/app/cn;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 307
    iget-object v0, p0, Lcom/wishabi/flipp/app/cr;->a:Lcom/wishabi/flipp/app/cn;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/cn;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 308
    if-nez v0, :cond_0

    .line 335
    :goto_0
    return-void

    .line 311
    :cond_0
    new-instance v1, Lcom/wishabi/flipp/app/cs;

    invoke-direct {v1, p0, v0}, Lcom/wishabi/flipp/app/cs;-><init>(Lcom/wishabi/flipp/app/cr;Landroid/content/Context;)V

    invoke-virtual {v1}, Lcom/wishabi/flipp/app/cs;->a()V

    goto :goto_0
.end method
