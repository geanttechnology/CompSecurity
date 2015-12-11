.class final Lcom/wishabi/flipp/app/fk;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnShowListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/fg;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/fg;)V
    .locals 0

    .prologue
    .line 140
    iput-object p1, p0, Lcom/wishabi/flipp/app/fk;->a:Lcom/wishabi/flipp/app/fg;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onShow(Landroid/content/DialogInterface;)V
    .locals 1

    .prologue
    .line 143
    iget-object v0, p0, Lcom/wishabi/flipp/app/fk;->a:Lcom/wishabi/flipp/app/fg;

    invoke-static {v0}, Lcom/wishabi/flipp/app/fg;->e(Lcom/wishabi/flipp/app/fg;)V

    .line 144
    return-void
.end method
