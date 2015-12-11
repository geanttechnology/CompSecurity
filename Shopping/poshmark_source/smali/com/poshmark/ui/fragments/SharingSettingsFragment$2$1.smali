.class Lcom/poshmark/ui/fragments/SharingSettingsFragment$2$1;
.super Ljava/lang/Object;
.source "SharingSettingsFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/SharingSettingsFragment$2;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/ui/fragments/SharingSettingsFragment$2;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/SharingSettingsFragment$2;)V
    .locals 0

    .prologue
    .line 179
    iput-object p1, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$2$1;->this$1:Lcom/poshmark/ui/fragments/SharingSettingsFragment$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 182
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 183
    return-void
.end method
