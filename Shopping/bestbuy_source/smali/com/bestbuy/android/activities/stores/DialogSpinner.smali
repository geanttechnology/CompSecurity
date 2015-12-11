.class public Lcom/bestbuy/android/activities/stores/DialogSpinner;
.super Landroid/widget/Spinner;
.source "SourceFile"


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0, p1}, Landroid/widget/Spinner;-><init>(Landroid/content/Context;)V

    .line 21
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0, p1, p2}, Landroid/widget/Spinner;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 17
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/Spinner;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 13
    return-void
.end method


# virtual methods
.method public performClick()Z
    .locals 3

    .prologue
    .line 25
    new-instance v1, Landroid/app/AlertDialog$Builder;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-direct {v1, v0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->getAdapter()Landroid/widget/SpinnerAdapter;

    move-result-object v0

    check-cast v0, Landroid/widget/ListAdapter;

    new-instance v2, Lcom/bestbuy/android/activities/stores/DialogSpinner$1;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/activities/stores/DialogSpinner$1;-><init>(Lcom/bestbuy/android/activities/stores/DialogSpinner;)V

    invoke-virtual {v1, v0, v2}, Landroid/app/AlertDialog$Builder;->setAdapter(Landroid/widget/ListAdapter;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 32
    const/4 v0, 0x1

    return v0
.end method

.method public setSelection(I)V
    .locals 6

    .prologue
    .line 38
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->getSelectedItemPosition()I

    move-result v0

    if-ne p1, v0, :cond_1

    const/4 v0, 0x1

    .line 39
    :goto_0
    invoke-super {p0, p1}, Landroid/widget/Spinner;->setSelection(I)V

    .line 40
    if-eqz v0, :cond_0

    .line 42
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->getOnItemSelectedListener()Landroid/widget/AdapterView$OnItemSelectedListener;

    move-result-object v0

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->getSelectedView()Landroid/view/View;

    move-result-object v2

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->getSelectedItemId()J

    move-result-wide v4

    move-object v1, p0

    move v3, p1

    invoke-interface/range {v0 .. v5}, Landroid/widget/AdapterView$OnItemSelectedListener;->onItemSelected(Landroid/widget/AdapterView;Landroid/view/View;IJ)V

    .line 44
    :cond_0
    return-void

    .line 38
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
