.class Lcom/poshmark/ui/customviews/PMTabButton$1;
.super Ljava/lang/Object;
.source "PMTabButton.java"

# interfaces
.implements Lcom/poshmark/ui/customviews/PMTabBar$PMTabListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/customviews/PMTabButton;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/customviews/PMTabButton;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/customviews/PMTabButton;)V
    .locals 0

    .prologue
    .line 127
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMTabButton$1;->this$0:Lcom/poshmark/ui/customviews/PMTabButton;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTabSelected(Lcom/poshmark/ui/customviews/PMTabButton;)V
    .locals 0
    .param p1, "tab"    # Lcom/poshmark/ui/customviews/PMTabButton;

    .prologue
    .line 130
    return-void
.end method

.method public onTabUnselected(Lcom/poshmark/ui/customviews/PMTabButton;)V
    .locals 0
    .param p1, "tab"    # Lcom/poshmark/ui/customviews/PMTabButton;

    .prologue
    .line 134
    return-void
.end method
