.class final Lcom/wishabi/flipp/app/ci;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/HelpActivity;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/HelpActivity;)V
    .locals 0

    .prologue
    .line 381
    iput-object p1, p0, Lcom/wishabi/flipp/app/ci;->a:Lcom/wishabi/flipp/app/HelpActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 384
    iget-object v0, p0, Lcom/wishabi/flipp/app/ci;->a:Lcom/wishabi/flipp/app/HelpActivity;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/HelpActivity;->finish()V

    .line 385
    return-void
.end method
