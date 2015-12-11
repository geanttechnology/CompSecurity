.class Lcom/bestbuy/android/activities/privacyandterms/PrivacyTermsFragment$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/privacyandterms/PrivacyTermsFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/privacyandterms/PrivacyTermsFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/privacyandterms/PrivacyTermsFragment;)V
    .locals 0

    .prologue
    .line 62
    iput-object p1, p0, Lcom/bestbuy/android/activities/privacyandterms/PrivacyTermsFragment$2;->a:Lcom/bestbuy/android/activities/privacyandterms/PrivacyTermsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 66
    iget-object v0, p0, Lcom/bestbuy/android/activities/privacyandterms/PrivacyTermsFragment$2;->a:Lcom/bestbuy/android/activities/privacyandterms/PrivacyTermsFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/privacyandterms/PrivacyTermsFragment$2;->a:Lcom/bestbuy/android/activities/privacyandterms/PrivacyTermsFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/privacyandterms/PrivacyTermsFragment;->a(Lcom/bestbuy/android/activities/privacyandterms/PrivacyTermsFragment;)Lnb;

    move-result-object v1

    invoke-virtual {v1}, Lnb;->e()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/privacyandterms/PrivacyTermsFragment;->a(Lcom/bestbuy/android/activities/privacyandterms/PrivacyTermsFragment;Ljava/lang/String;)V

    .line 67
    return-void
.end method
