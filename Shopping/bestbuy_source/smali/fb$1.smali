.class Lfb$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lfb;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lfc;

.field final synthetic b:Lfb;


# direct methods
.method constructor <init>(Lfb;Lfc;)V
    .locals 0

    .prologue
    .line 83
    iput-object p1, p0, Lfb$1;->b:Lfb;

    iput-object p2, p0, Lfb$1;->a:Lfc;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    const/16 v2, 0x8

    .line 86
    iget-object v0, p0, Lfb$1;->b:Lfb;

    iget-object v1, p0, Lfb$1;->a:Lfc;

    iget-object v1, v1, Lfc;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getLineCount()I

    move-result v1

    invoke-static {v0, v1}, Lfb;->a(Lfb;I)I

    .line 87
    iget-object v0, p0, Lfb$1;->b:Lfb;

    invoke-static {v0}, Lfb;->a(Lfb;)I

    move-result v0

    const/4 v1, 0x5

    if-gt v0, v1, :cond_0

    .line 88
    iget-object v0, p0, Lfb$1;->a:Lfc;

    iget-object v0, v0, Lfc;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 89
    iget-object v0, p0, Lfb$1;->a:Lfc;

    iget-object v0, v0, Lfc;->i:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 96
    :goto_0
    return-void

    .line 91
    :cond_0
    iget-object v0, p0, Lfb$1;->a:Lfc;

    iget-object v0, v0, Lfc;->i:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getVisibility()I

    move-result v0

    if-nez v0, :cond_1

    .line 92
    iget-object v0, p0, Lfb$1;->a:Lfc;

    iget-object v0, v0, Lfc;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto :goto_0

    .line 94
    :cond_1
    iget-object v0, p0, Lfb$1;->a:Lfc;

    iget-object v0, v0, Lfc;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto :goto_0
.end method
