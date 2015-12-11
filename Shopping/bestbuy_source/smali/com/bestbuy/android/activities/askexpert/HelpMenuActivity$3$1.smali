.class Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$3$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$3;->onClick(Landroid/view/View;)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$3;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$3;)V
    .locals 0

    .prologue
    .line 177
    iput-object p1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$3$1;->a:Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$3;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0

    .prologue
    .line 180
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 181
    return-void
.end method
