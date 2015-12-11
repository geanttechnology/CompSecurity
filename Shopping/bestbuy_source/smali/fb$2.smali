.class Lfb$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


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
    .line 99
    iput-object p1, p0, Lfb$2;->b:Lfb;

    iput-object p2, p0, Lfb$2;->a:Lfc;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 102
    iget-object v0, p0, Lfb$2;->a:Lfc;

    iget-object v0, v0, Lfc;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const v1, 0x7fffffff

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setMaxLines(I)V

    .line 103
    iget-object v0, p0, Lfb$2;->a:Lfc;

    iget-object v0, v0, Lfc;->i:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 104
    iget-object v0, p0, Lfb$2;->a:Lfc;

    iget-object v0, v0, Lfc;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 105
    iget-object v0, p0, Lfb$2;->a:Lfc;

    iget-object v0, v0, Lfc;->i:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v1, Lfb$2$1;

    invoke-direct {v1, p0}, Lfb$2$1;-><init>(Lfb$2;)V

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 113
    return-void
.end method
