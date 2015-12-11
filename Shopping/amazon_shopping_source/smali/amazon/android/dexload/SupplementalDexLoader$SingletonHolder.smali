.class Lamazon/android/dexload/SupplementalDexLoader$SingletonHolder;
.super Ljava/lang/Object;
.source "SupplementalDexLoader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lamazon/android/dexload/SupplementalDexLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SingletonHolder"
.end annotation


# static fields
.field public static final INSTANCE:Lamazon/android/dexload/SupplementalDexLoader;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 69
    new-instance v0, Lamazon/android/dexload/SupplementalDexLoader;

    invoke-direct {v0}, Lamazon/android/dexload/SupplementalDexLoader;-><init>()V

    sput-object v0, Lamazon/android/dexload/SupplementalDexLoader$SingletonHolder;->INSTANCE:Lamazon/android/dexload/SupplementalDexLoader;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 68
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
