.class Lcom/poshmark/ui/customviews/PMTextView$4;
.super Ljava/lang/Object;
.source "PMTextView.java"

# interfaces
.implements Lcom/poshmark/utils/TextClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/customviews/PMTextView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/customviews/PMTextView;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/customviews/PMTextView;)V
    .locals 0

    .prologue
    .line 75
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMTextView$4;->this$0:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Ljava/lang/String;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 79
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 85
    .local v0, "b":Landroid/os/Bundle;
    return-void
.end method
