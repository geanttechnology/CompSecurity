.class interface abstract Lco/vine/android/util/ContactsHelper$ProfileQuery;
.super Ljava/lang/Object;
.source "ContactsHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/util/ContactsHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x60a
    name = "ProfileQuery"
.end annotation


# static fields
.field public static final INDEX_MIME_TYPE:I = 0x2

.field public static final INDEX_PHONE_NUMBER:I = 0x1

.field public static final PROJECTION:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 39
    const/4 v0, 0x3

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "_id"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "data1"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "mimetype"

    aput-object v2, v0, v1

    sput-object v0, Lco/vine/android/util/ContactsHelper$ProfileQuery;->PROJECTION:[Ljava/lang/String;

    return-void
.end method
