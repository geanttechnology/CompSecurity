.class Lcom/bestbuy/android/activities/registry/WeddingDateFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/app/DatePickerDialog$OnDateSetListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/registry/WeddingDateFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/registry/WeddingDateFragment;)V
    .locals 0

    .prologue
    .line 88
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment$1;->a:Lcom/bestbuy/android/activities/registry/WeddingDateFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private a()V
    .locals 3

    .prologue
    .line 100
    const-string v0, "MM/dd/yyyy"

    .line 101
    new-instance v1, Ljava/text/SimpleDateFormat;

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {v1, v0, v2}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 102
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment$1;->a:Lcom/bestbuy/android/activities/registry/WeddingDateFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->b(Lcom/bestbuy/android/activities/registry/WeddingDateFragment;)Landroid/widget/EditText;

    move-result-object v0

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment$1;->a:Lcom/bestbuy/android/activities/registry/WeddingDateFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->a(Lcom/bestbuy/android/activities/registry/WeddingDateFragment;)Ljava/util/Calendar;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 103
    return-void
.end method


# virtual methods
.method public onDateSet(Landroid/widget/DatePicker;III)V
    .locals 2

    .prologue
    .line 93
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment$1;->a:Lcom/bestbuy/android/activities/registry/WeddingDateFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->a(Lcom/bestbuy/android/activities/registry/WeddingDateFragment;)Ljava/util/Calendar;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1, p2}, Ljava/util/Calendar;->set(II)V

    .line 94
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment$1;->a:Lcom/bestbuy/android/activities/registry/WeddingDateFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->a(Lcom/bestbuy/android/activities/registry/WeddingDateFragment;)Ljava/util/Calendar;

    move-result-object v0

    const/4 v1, 0x2

    invoke-virtual {v0, v1, p3}, Ljava/util/Calendar;->set(II)V

    .line 95
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment$1;->a:Lcom/bestbuy/android/activities/registry/WeddingDateFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->a(Lcom/bestbuy/android/activities/registry/WeddingDateFragment;)Ljava/util/Calendar;

    move-result-object v0

    const/4 v1, 0x5

    invoke-virtual {v0, v1, p4}, Ljava/util/Calendar;->set(II)V

    .line 96
    invoke-direct {p0}, Lcom/bestbuy/android/activities/registry/WeddingDateFragment$1;->a()V

    .line 97
    return-void
.end method
