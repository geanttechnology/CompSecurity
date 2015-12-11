.class final Lcom/wishabi/flipp/widget/dt;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:I

.field final synthetic b:I

.field final synthetic c:Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;II)V
    .locals 0

    .prologue
    .line 66
    iput-object p1, p0, Lcom/wishabi/flipp/widget/dt;->c:Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;

    iput p2, p0, Lcom/wishabi/flipp/widget/dt;->a:I

    iput p3, p0, Lcom/wishabi/flipp/widget/dt;->b:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 3

    .prologue
    .line 69
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dt;->c:Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;

    iget v1, p0, Lcom/wishabi/flipp/widget/dt;->a:I

    iget v2, p0, Lcom/wishabi/flipp/widget/dt;->b:I

    invoke-static {v0, v1, v2}, Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;->a(Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;II)V

    .line 70
    return-void
.end method
