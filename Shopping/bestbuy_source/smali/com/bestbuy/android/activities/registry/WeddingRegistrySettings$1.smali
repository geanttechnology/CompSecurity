.class Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/app/DatePickerDialog$OnDateSetListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)V
    .locals 0

    .prologue
    .line 168
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$1;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private a()V
    .locals 3

    .prologue
    .line 180
    const-string v0, "MM/dd/yyyy"

    .line 181
    new-instance v1, Ljava/text/SimpleDateFormat;

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {v1, v0, v2}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 182
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$1;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->b(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$1;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v2}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Ljava/util/Calendar;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 183
    return-void
.end method


# virtual methods
.method public onDateSet(Landroid/widget/DatePicker;III)V
    .locals 2

    .prologue
    .line 173
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$1;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Ljava/util/Calendar;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1, p2}, Ljava/util/Calendar;->set(II)V

    .line 174
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$1;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Ljava/util/Calendar;

    move-result-object v0

    const/4 v1, 0x2

    invoke-virtual {v0, v1, p3}, Ljava/util/Calendar;->set(II)V

    .line 175
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$1;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Ljava/util/Calendar;

    move-result-object v0

    const/4 v1, 0x5

    invoke-virtual {v0, v1, p4}, Ljava/util/Calendar;->set(II)V

    .line 176
    invoke-direct {p0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$1;->a()V

    .line 177
    return-void
.end method
