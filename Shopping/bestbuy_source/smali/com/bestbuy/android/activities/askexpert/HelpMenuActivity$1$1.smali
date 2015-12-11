.class Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$1$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$1;->onClick(Landroid/view/View;)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$1;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$1;)V
    .locals 0

    .prologue
    .line 121
    iput-object p1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$1$1;->a:Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0

    .prologue
    .line 124
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 125
    return-void
.end method
