.class final Lcom/wishabi/flipp/app/ch;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/cg;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/cg;)V
    .locals 0

    .prologue
    .line 66
    iput-object p1, p0, Lcom/wishabi/flipp/app/ch;->a:Lcom/wishabi/flipp/app/cg;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/content/DialogInterface;I)V
    .locals 0

    .prologue
    .line 70
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 71
    return-void
.end method
