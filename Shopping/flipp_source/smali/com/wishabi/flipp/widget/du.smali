.class final Lcom/wishabi/flipp/widget/du;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;)V
    .locals 0

    .prologue
    .line 128
    iput-object p1, p0, Lcom/wishabi/flipp/widget/du;->a:Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 131
    iget-object v0, p0, Lcom/wishabi/flipp/widget/du;->a:Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;->a(Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;)Lcom/wishabi/flipp/widget/dv;

    move-result-object v0

    check-cast p1, Landroid/widget/TextView;

    invoke-interface {v0, p1}, Lcom/wishabi/flipp/widget/dv;->a(Landroid/widget/TextView;)V

    .line 132
    return-void
.end method
