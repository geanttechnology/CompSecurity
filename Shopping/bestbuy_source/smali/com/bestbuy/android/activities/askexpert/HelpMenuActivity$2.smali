.class Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;)V
    .locals 0

    .prologue
    .line 134
    iput-object p1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$2;->a:Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 137
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$2;->a:Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;

    invoke-static {v0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->c(Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$2;->a:Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;

    invoke-static {v0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->c(Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "PurchasingProduct"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 138
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 139
    const-string v1, "bb.prevPageLink"

    sget-object v2, Llu;->aV:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 140
    const-string v1, "bb.makeAppt"

    const-string v2, "1"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 141
    sget-object v1, Llu;->aY:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 149
    :cond_0
    :goto_0
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$2;->a:Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;

    const-class v2, Lcom/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 153
    iget-object v1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$2;->a:Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->startActivity(Landroid/content/Intent;)V

    .line 154
    return-void

    .line 142
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$2;->a:Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;

    invoke-static {v0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->c(Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$2;->a:Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;

    invoke-static {v0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->c(Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "ExistingOrder"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 143
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 144
    const-string v1, "bb.prevPageLink"

    const-string v2, "Blue Assist: Existing Order: Mobile"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 145
    const-string v1, "bb.makeAppt"

    const-string v2, "1"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 146
    const-string v1, "Blue Assist: Existing Order: Mobile: Make Appt"

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    goto :goto_0
.end method
