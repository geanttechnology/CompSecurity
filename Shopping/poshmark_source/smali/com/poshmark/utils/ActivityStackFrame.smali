.class public Lcom/poshmark/utils/ActivityStackFrame;
.super Ljava/lang/Object;
.source "ActivityStackFrame.java"


# instance fields
.field public fragment:Lcom/poshmark/ui/fragments/PMFragment;

.field public tab:Landroid/app/ActionBar$Tab;


# direct methods
.method public constructor <init>(Lcom/poshmark/ui/fragments/PMFragment;Landroid/app/ActionBar$Tab;)V
    .locals 0
    .param p1, "fragment"    # Lcom/poshmark/ui/fragments/PMFragment;
    .param p2, "tab"    # Landroid/app/ActionBar$Tab;

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    iput-object p1, p0, Lcom/poshmark/utils/ActivityStackFrame;->fragment:Lcom/poshmark/ui/fragments/PMFragment;

    .line 13
    iput-object p2, p0, Lcom/poshmark/utils/ActivityStackFrame;->tab:Landroid/app/ActionBar$Tab;

    .line 14
    return-void
.end method
