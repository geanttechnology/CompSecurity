.class public Lcom/wishabi/flipp/content/FormattedString;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/wishabi/flipp/content/FormattedString;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final a:[Lcom/wishabi/flipp/content/FormattedString$Part;

.field private b:Landroid/text/Spannable;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 211
    new-instance v0, Lcom/wishabi/flipp/content/y;

    invoke-direct {v0}, Lcom/wishabi/flipp/content/y;-><init>()V

    sput-object v0, Lcom/wishabi/flipp/content/FormattedString;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method private constructor <init>(Landroid/os/Parcel;)V
    .locals 1

    .prologue
    .line 153
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 154
    sget-object v0, Lcom/wishabi/flipp/content/FormattedString$Part;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->createTypedArray(Landroid/os/Parcelable$Creator;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/wishabi/flipp/content/FormattedString$Part;

    iput-object v0, p0, Lcom/wishabi/flipp/content/FormattedString;->a:[Lcom/wishabi/flipp/content/FormattedString$Part;

    .line 155
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/wishabi/flipp/content/FormattedString;->b:Landroid/text/Spannable;

    .line 156
    return-void
.end method

.method synthetic constructor <init>(Landroid/os/Parcel;B)V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0, p1}, Lcom/wishabi/flipp/content/FormattedString;-><init>(Landroid/os/Parcel;)V

    return-void
.end method

.method public varargs constructor <init>([Lcom/wishabi/flipp/content/FormattedString$Part;)V
    .locals 1

    .prologue
    .line 148
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 149
    iput-object p1, p0, Lcom/wishabi/flipp/content/FormattedString;->a:[Lcom/wishabi/flipp/content/FormattedString$Part;

    .line 150
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/wishabi/flipp/content/FormattedString;->b:Landroid/text/Spannable;

    .line 151
    return-void
.end method


# virtual methods
.method public final a()Landroid/text/Spannable;
    .locals 14

    .prologue
    const/4 v1, 0x0

    const/16 v13, 0x21

    .line 159
    iget-object v0, p0, Lcom/wishabi/flipp/content/FormattedString;->b:Landroid/text/Spannable;

    if-eqz v0, :cond_0

    .line 160
    iget-object v0, p0, Lcom/wishabi/flipp/content/FormattedString;->b:Landroid/text/Spannable;

    .line 198
    :goto_0
    return-object v0

    .line 162
    :cond_0
    new-instance v3, Landroid/text/SpannableStringBuilder;

    invoke-direct {v3}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 163
    iget-object v4, p0, Lcom/wishabi/flipp/content/FormattedString;->a:[Lcom/wishabi/flipp/content/FormattedString$Part;

    array-length v5, v4

    move v2, v1

    :goto_1
    if-ge v2, v5, :cond_2

    aget-object v0, v4, v2

    .line 164
    invoke-virtual {v3}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v6

    .line 165
    iget-object v7, v0, Lcom/wishabi/flipp/content/FormattedString$Part;->a:Ljava/lang/String;

    invoke-virtual {v3, v7}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 166
    invoke-virtual {v3}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v7

    .line 168
    iget-object v8, v0, Lcom/wishabi/flipp/content/FormattedString$Part;->b:[Lcom/wishabi/flipp/content/FormattedString$Format;

    array-length v9, v8

    move v0, v1

    :goto_2
    if-ge v0, v9, :cond_1

    aget-object v10, v8, v0

    .line 169
    sget-object v11, Lcom/wishabi/flipp/content/z;->a:[I

    iget v12, v10, Lcom/wishabi/flipp/content/FormattedString$Format;->a:I

    add-int/lit8 v12, v12, -0x1

    aget v11, v11, v12

    packed-switch v11, :pswitch_data_0

    .line 189
    :goto_3
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 171
    :pswitch_0
    new-instance v10, Landroid/text/style/StyleSpan;

    const/4 v11, 0x1

    invoke-direct {v10, v11}, Landroid/text/style/StyleSpan;-><init>(I)V

    invoke-virtual {v3, v10, v6, v7, v13}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    goto :goto_3

    .line 175
    :pswitch_1
    new-instance v10, Landroid/text/style/StyleSpan;

    const/4 v11, 0x2

    invoke-direct {v10, v11}, Landroid/text/style/StyleSpan;-><init>(I)V

    invoke-virtual {v3, v10, v6, v7, v13}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    goto :goto_3

    .line 179
    :pswitch_2
    new-instance v11, Landroid/text/style/ForegroundColorSpan;

    iget v10, v10, Lcom/wishabi/flipp/content/FormattedString$Format;->b:I

    invoke-direct {v11, v10}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    invoke-virtual {v3, v11, v6, v7, v13}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    goto :goto_3

    .line 183
    :pswitch_3
    new-instance v11, Landroid/text/style/BackgroundColorSpan;

    iget v10, v10, Lcom/wishabi/flipp/content/FormattedString$Format;->b:I

    invoke-direct {v11, v10}, Landroid/text/style/BackgroundColorSpan;-><init>(I)V

    invoke-virtual {v3, v11, v6, v7, v13}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    goto :goto_3

    .line 187
    :pswitch_4
    new-instance v11, Landroid/text/style/RelativeSizeSpan;

    iget v10, v10, Lcom/wishabi/flipp/content/FormattedString$Format;->c:F

    invoke-direct {v11, v10}, Landroid/text/style/RelativeSizeSpan;-><init>(F)V

    invoke-virtual {v3, v11, v6, v7, v13}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    goto :goto_3

    .line 163
    :cond_1
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_1

    .line 196
    :cond_2
    iput-object v3, p0, Lcom/wishabi/flipp/content/FormattedString;->b:Landroid/text/Spannable;

    .line 198
    iget-object v0, p0, Lcom/wishabi/flipp/content/FormattedString;->b:Landroid/text/Spannable;

    goto :goto_0

    .line 169
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method public describeContents()I
    .locals 1

    .prologue
    .line 203
    const/4 v0, 0x0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1

    .prologue
    .line 208
    iget-object v0, p0, Lcom/wishabi/flipp/content/FormattedString;->a:[Lcom/wishabi/flipp/content/FormattedString$Part;

    invoke-virtual {p1, v0, p2}, Landroid/os/Parcel;->writeTypedArray([Landroid/os/Parcelable;I)V

    .line 209
    return-void
.end method
