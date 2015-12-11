.class Lfb$2$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lfb$2;->onClick(Landroid/view/View;)V
.end annotation


# instance fields
.field final synthetic a:Lfb$2;


# direct methods
.method constructor <init>(Lfb$2;)V
    .locals 0

    .prologue
    .line 105
    iput-object p1, p0, Lfb$2$1;->a:Lfb$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 108
    iget-object v0, p0, Lfb$2$1;->a:Lfb$2;

    iget-object v0, v0, Lfb$2;->a:Lfc;

    iget-object v0, v0, Lfc;->i:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 109
    iget-object v0, p0, Lfb$2$1;->a:Lfb$2;

    iget-object v0, v0, Lfb$2;->a:Lfc;

    iget-object v0, v0, Lfc;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 110
    iget-object v0, p0, Lfb$2$1;->a:Lfb$2;

    iget-object v0, v0, Lfb$2;->a:Lfc;

    iget-object v0, v0, Lfc;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v1, 0x5

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setMaxLines(I)V

    .line 111
    return-void
.end method
