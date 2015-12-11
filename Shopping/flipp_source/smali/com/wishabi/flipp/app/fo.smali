.class final Lcom/wishabi/flipp/app/fo;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/fn;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/fn;)V
    .locals 0

    .prologue
    .line 86
    iput-object p1, p0, Lcom/wishabi/flipp/app/fo;->a:Lcom/wishabi/flipp/app/fn;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lcom/wishabi/flipp/app/fo;->a:Lcom/wishabi/flipp/app/fn;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/fn;->dismiss()V

    .line 90
    return-void
.end method
