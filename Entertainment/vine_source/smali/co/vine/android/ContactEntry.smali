.class public Lco/vine/android/ContactEntry;
.super Ljava/lang/Object;
.source "ContactEntry.java"

# interfaces
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/lang/Comparable",
        "<",
        "Lco/vine/android/ContactEntry;",
        ">;"
    }
.end annotation


# static fields
.field public static final sProjection:[Ljava/lang/String;

.field public static final sSelection:Ljava/lang/String; = "mimetype=? OR mimetype=?"

.field public static final sSelectionArgs:[Ljava/lang/String;

.field public static final sSortOrder:Ljava/lang/String; = "contact_id ASC "

.field public static final sUri:Landroid/net/Uri;


# instance fields
.field public alternateName:Ljava/lang/String;

.field public contactId:J

.field public displayName:Ljava/lang/String;

.field public typeFlag:I

.field public valueMimeMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 17
    sget-object v0, Landroid/provider/ContactsContract$Data;->CONTENT_URI:Landroid/net/Uri;

    sput-object v0, Lco/vine/android/ContactEntry;->sUri:Landroid/net/Uri;

    .line 19
    const/4 v0, 0x5

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "contact_id"

    aput-object v1, v0, v3

    const-string v1, "display_name"

    aput-object v1, v0, v4

    const-string v1, "display_name_alt"

    aput-object v1, v0, v5

    const/4 v1, 0x3

    const-string v2, "mimetype"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "data1"

    aput-object v2, v0, v1

    sput-object v0, Lco/vine/android/ContactEntry;->sProjection:[Ljava/lang/String;

    .line 28
    new-array v0, v5, [Ljava/lang/String;

    const-string v1, "vnd.android.cursor.item/email_v2"

    aput-object v1, v0, v3

    const-string v1, "vnd.android.cursor.item/phone_v2"

    aput-object v1, v0, v4

    sput-object v0, Lco/vine/android/ContactEntry;->sSelectionArgs:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/database/Cursor;)V
    .locals 4
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    const/4 v1, 0x2

    const/4 v0, 0x1

    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    iput-object v2, p0, Lco/vine/android/ContactEntry;->valueMimeMap:Ljava/util/HashMap;

    .line 42
    const/4 v2, 0x0

    invoke-interface {p1, v2}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    iput-wide v2, p0, Lco/vine/android/ContactEntry;->contactId:J

    .line 43
    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lco/vine/android/ContactEntry;->displayName:Ljava/lang/String;

    .line 44
    invoke-interface {p1, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lco/vine/android/ContactEntry;->alternateName:Ljava/lang/String;

    .line 45
    const-string v2, "vnd.android.cursor.item/email_v2"

    const/4 v3, 0x3

    invoke-interface {p1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    :goto_0
    iput v0, p0, Lco/vine/android/ContactEntry;->typeFlag:I

    .line 47
    return-void

    :cond_0
    move v0, v1

    .line 45
    goto :goto_0
.end method

.method private getCompareResult(Ljava/lang/String;Ljava/lang/String;)I
    .locals 4
    .param p1, "lhs"    # Ljava/lang/String;
    .param p2, "rhs"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 62
    invoke-virtual {p1, v3}, Ljava/lang/String;->charAt(I)C

    move-result v2

    invoke-static {v2}, Ljava/lang/Character;->isLetter(C)Z

    move-result v1

    .line 63
    .local v1, "thisStartsWithLetter":Z
    invoke-virtual {p2, v3}, Ljava/lang/String;->charAt(I)C

    move-result v2

    invoke-static {v2}, Ljava/lang/Character;->isLetter(C)Z

    move-result v0

    .line 65
    .local v0, "thatStartsWithLetter":Z
    if-eqz v1, :cond_0

    if-nez v0, :cond_1

    :cond_0
    if-nez v1, :cond_2

    if-nez v0, :cond_2

    .line 67
    :cond_1
    invoke-virtual {p1, p2}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v2

    .line 71
    :goto_0
    return v2

    .line 68
    :cond_2
    if-eqz v1, :cond_3

    .line 69
    const/4 v2, -0x1

    goto :goto_0

    .line 71
    :cond_3
    const/4 v2, 0x1

    goto :goto_0
.end method


# virtual methods
.method public compareTo(Lco/vine/android/ContactEntry;)I
    .locals 2
    .param p1, "contactEntry"    # Lco/vine/android/ContactEntry;

    .prologue
    .line 51
    iget-object v0, p0, Lco/vine/android/ContactEntry;->alternateName:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p1, Lco/vine/android/ContactEntry;->alternateName:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 52
    iget-object v0, p0, Lco/vine/android/ContactEntry;->alternateName:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p1, Lco/vine/android/ContactEntry;->alternateName:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lco/vine/android/ContactEntry;->getCompareResult(Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    .line 55
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lco/vine/android/ContactEntry;->displayName:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p1, Lco/vine/android/ContactEntry;->displayName:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lco/vine/android/ContactEntry;->getCompareResult(Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    goto :goto_0
.end method

.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 15
    check-cast p1, Lco/vine/android/ContactEntry;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lco/vine/android/ContactEntry;->compareTo(Lco/vine/android/ContactEntry;)I

    move-result v0

    return v0
.end method

.method public isSameSection(Lco/vine/android/ContactEntry;)Z
    .locals 3
    .param p1, "that"    # Lco/vine/android/ContactEntry;

    .prologue
    const/4 v0, 0x0

    .line 76
    iget-object v1, p0, Lco/vine/android/ContactEntry;->alternateName:Ljava/lang/String;

    if-eqz v1, :cond_1

    iget-object v1, p1, Lco/vine/android/ContactEntry;->alternateName:Ljava/lang/String;

    if-eqz v1, :cond_1

    .line 77
    iget-object v1, p0, Lco/vine/android/ContactEntry;->alternateName:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/String;->charAt(I)C

    move-result v1

    iget-object v2, p1, Lco/vine/android/ContactEntry;->alternateName:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/String;->charAt(I)C

    move-result v2

    if-eq v1, v2, :cond_2

    .line 87
    :cond_0
    :goto_0
    return v0

    .line 82
    :cond_1
    iget-object v1, p0, Lco/vine/android/ContactEntry;->displayName:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/String;->charAt(I)C

    move-result v1

    iget-object v2, p1, Lco/vine/android/ContactEntry;->displayName:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/String;->charAt(I)C

    move-result v2

    if-ne v1, v2, :cond_0

    .line 87
    :cond_2
    const/4 v0, 0x1

    goto :goto_0
.end method
