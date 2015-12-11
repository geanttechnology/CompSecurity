.class final Lcom/actionbarsherlock/internal/widget/IcsAbsSpinner$SavedState$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 408
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final createFromParcel(Landroid/os/Parcel;)Lcom/actionbarsherlock/internal/widget/IcsAbsSpinner$SavedState;
    .locals 2

    .prologue
    .line 410
    new-instance v0, Lcom/actionbarsherlock/internal/widget/IcsAbsSpinner$SavedState;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Lcom/actionbarsherlock/internal/widget/IcsAbsSpinner$SavedState;-><init>(Landroid/os/Parcel;Lcom/actionbarsherlock/internal/widget/IcsAbsSpinner$1;)V

    return-object v0
.end method

.method public final bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 408
    invoke-virtual {p0, p1}, Lcom/actionbarsherlock/internal/widget/IcsAbsSpinner$SavedState$1;->createFromParcel(Landroid/os/Parcel;)Lcom/actionbarsherlock/internal/widget/IcsAbsSpinner$SavedState;

    move-result-object v0

    return-object v0
.end method

.method public final newArray(I)[Lcom/actionbarsherlock/internal/widget/IcsAbsSpinner$SavedState;
    .locals 1

    .prologue
    .line 414
    new-array v0, p1, [Lcom/actionbarsherlock/internal/widget/IcsAbsSpinner$SavedState;

    return-object v0
.end method

.method public final bridge synthetic newArray(I)[Ljava/lang/Object;
    .locals 1

    .prologue
    .line 408
    invoke-virtual {p0, p1}, Lcom/actionbarsherlock/internal/widget/IcsAbsSpinner$SavedState$1;->newArray(I)[Lcom/actionbarsherlock/internal/widget/IcsAbsSpinner$SavedState;

    move-result-object v0

    return-object v0
.end method
