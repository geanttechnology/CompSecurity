.class final Lcom/wishabi/flipp/app/q;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# instance fields
.field final synthetic a:I

.field final synthetic b:Lcom/wishabi/flipp/app/o;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/o;I)V
    .locals 0

    .prologue
    .line 260
    iput-object p1, p0, Lcom/wishabi/flipp/app/q;->b:Lcom/wishabi/flipp/app/o;

    iput p2, p0, Lcom/wishabi/flipp/app/q;->a:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/content/DialogInterface;I)V
    .locals 2

    .prologue
    .line 263
    iget-object v0, p0, Lcom/wishabi/flipp/app/q;->b:Lcom/wishabi/flipp/app/o;

    iget-object v0, v0, Lcom/wishabi/flipp/app/o;->a:Lcom/wishabi/flipp/app/n;

    iget v1, p0, Lcom/wishabi/flipp/app/q;->a:I

    invoke-static {v0, v1}, Lcom/wishabi/flipp/app/n;->a(Lcom/wishabi/flipp/app/n;I)V

    .line 264
    return-void
.end method
