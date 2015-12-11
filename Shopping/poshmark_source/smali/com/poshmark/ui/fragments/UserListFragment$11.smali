.class synthetic Lcom/poshmark/ui/fragments/UserListFragment$11;
.super Ljava/lang/Object;
.source "UserListFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/UserListFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1008
    name = null
.end annotation


# static fields
.field static final synthetic $SwitchMap$com$poshmark$ui$customviews$CollectionSortWidget$SortType:[I

.field static final synthetic $SwitchMap$com$poshmark$ui$fragments$UserListFragment$USER_LIST_MODE:[I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 327
    invoke-static {}, Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;->values()[Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    sput-object v0, Lcom/poshmark/ui/fragments/UserListFragment$11;->$SwitchMap$com$poshmark$ui$customviews$CollectionSortWidget$SortType:[I

    :try_start_0
    sget-object v0, Lcom/poshmark/ui/fragments/UserListFragment$11;->$SwitchMap$com$poshmark$ui$customviews$CollectionSortWidget$SortType:[I

    sget-object v1, Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;->Left:Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_c

    :goto_0
    :try_start_1
    sget-object v0, Lcom/poshmark/ui/fragments/UserListFragment$11;->$SwitchMap$com$poshmark$ui$customviews$CollectionSortWidget$SortType:[I

    sget-object v1, Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;->Right:Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_b

    .line 69
    :goto_1
    invoke-static {}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->values()[Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    sput-object v0, Lcom/poshmark/ui/fragments/UserListFragment$11;->$SwitchMap$com$poshmark$ui$fragments$UserListFragment$USER_LIST_MODE:[I

    :try_start_2
    sget-object v0, Lcom/poshmark/ui/fragments/UserListFragment$11;->$SwitchMap$com$poshmark$ui$fragments$UserListFragment$USER_LIST_MODE:[I

    sget-object v1, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->LIKES_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_2
    .catch Ljava/lang/NoSuchFieldError; {:try_start_2 .. :try_end_2} :catch_a

    :goto_2
    :try_start_3
    sget-object v0, Lcom/poshmark/ui/fragments/UserListFragment$11;->$SwitchMap$com$poshmark$ui$fragments$UserListFragment$USER_LIST_MODE:[I

    sget-object v1, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->PM_FOLLOWERS_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_3
    .catch Ljava/lang/NoSuchFieldError; {:try_start_3 .. :try_end_3} :catch_9

    :goto_3
    :try_start_4
    sget-object v0, Lcom/poshmark/ui/fragments/UserListFragment$11;->$SwitchMap$com$poshmark$ui$fragments$UserListFragment$USER_LIST_MODE:[I

    sget-object v1, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->PM_FOLLOWING_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1
    :try_end_4
    .catch Ljava/lang/NoSuchFieldError; {:try_start_4 .. :try_end_4} :catch_8

    :goto_4
    :try_start_5
    sget-object v0, Lcom/poshmark/ui/fragments/UserListFragment$11;->$SwitchMap$com$poshmark$ui$fragments$UserListFragment$USER_LIST_MODE:[I

    sget-object v1, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->FB_FRIENDS_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->ordinal()I

    move-result v1

    const/4 v2, 0x4

    aput v2, v0, v1
    :try_end_5
    .catch Ljava/lang/NoSuchFieldError; {:try_start_5 .. :try_end_5} :catch_7

    :goto_5
    :try_start_6
    sget-object v0, Lcom/poshmark/ui/fragments/UserListFragment$11;->$SwitchMap$com$poshmark$ui$fragments$UserListFragment$USER_LIST_MODE:[I

    sget-object v1, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->TWITTER_FRIENDS_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->ordinal()I

    move-result v1

    const/4 v2, 0x5

    aput v2, v0, v1
    :try_end_6
    .catch Ljava/lang/NoSuchFieldError; {:try_start_6 .. :try_end_6} :catch_6

    :goto_6
    :try_start_7
    sget-object v0, Lcom/poshmark/ui/fragments/UserListFragment$11;->$SwitchMap$com$poshmark$ui$fragments$UserListFragment$USER_LIST_MODE:[I

    sget-object v1, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->SUGGESTED_USERS_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->ordinal()I

    move-result v1

    const/4 v2, 0x6

    aput v2, v0, v1
    :try_end_7
    .catch Ljava/lang/NoSuchFieldError; {:try_start_7 .. :try_end_7} :catch_5

    :goto_7
    :try_start_8
    sget-object v0, Lcom/poshmark/ui/fragments/UserListFragment$11;->$SwitchMap$com$poshmark$ui$fragments$UserListFragment$USER_LIST_MODE:[I

    sget-object v1, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->SECONDARY_SUGGESTED_USERS_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->ordinal()I

    move-result v1

    const/4 v2, 0x7

    aput v2, v0, v1
    :try_end_8
    .catch Ljava/lang/NoSuchFieldError; {:try_start_8 .. :try_end_8} :catch_4

    :goto_8
    :try_start_9
    sget-object v0, Lcom/poshmark/ui/fragments/UserListFragment$11;->$SwitchMap$com$poshmark$ui$fragments$UserListFragment$USER_LIST_MODE:[I

    sget-object v1, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->SEARCH_PEOPLE_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->ordinal()I

    move-result v1

    const/16 v2, 0x8

    aput v2, v0, v1
    :try_end_9
    .catch Ljava/lang/NoSuchFieldError; {:try_start_9 .. :try_end_9} :catch_3

    :goto_9
    :try_start_a
    sget-object v0, Lcom/poshmark/ui/fragments/UserListFragment$11;->$SwitchMap$com$poshmark$ui$fragments$UserListFragment$USER_LIST_MODE:[I

    sget-object v1, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->CLOSETS_SHARED_FIRST:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->ordinal()I

    move-result v1

    const/16 v2, 0x9

    aput v2, v0, v1
    :try_end_a
    .catch Ljava/lang/NoSuchFieldError; {:try_start_a .. :try_end_a} :catch_2

    :goto_a
    :try_start_b
    sget-object v0, Lcom/poshmark/ui/fragments/UserListFragment$11;->$SwitchMap$com$poshmark$ui$fragments$UserListFragment$USER_LIST_MODE:[I

    sget-object v1, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->NEWLY_OPENED_CLOSETS:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->ordinal()I

    move-result v1

    const/16 v2, 0xa

    aput v2, v0, v1
    :try_end_b
    .catch Ljava/lang/NoSuchFieldError; {:try_start_b .. :try_end_b} :catch_1

    :goto_b
    :try_start_c
    sget-object v0, Lcom/poshmark/ui/fragments/UserListFragment$11;->$SwitchMap$com$poshmark$ui$fragments$UserListFragment$USER_LIST_MODE:[I

    sget-object v1, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->NEWLY_JOINED_CLOSETS:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->ordinal()I

    move-result v1

    const/16 v2, 0xb

    aput v2, v0, v1
    :try_end_c
    .catch Ljava/lang/NoSuchFieldError; {:try_start_c .. :try_end_c} :catch_0

    :goto_c
    return-void

    :catch_0
    move-exception v0

    goto :goto_c

    :catch_1
    move-exception v0

    goto :goto_b

    :catch_2
    move-exception v0

    goto :goto_a

    :catch_3
    move-exception v0

    goto :goto_9

    :catch_4
    move-exception v0

    goto :goto_8

    :catch_5
    move-exception v0

    goto :goto_7

    :catch_6
    move-exception v0

    goto :goto_6

    :catch_7
    move-exception v0

    goto :goto_5

    :catch_8
    move-exception v0

    goto :goto_4

    :catch_9
    move-exception v0

    goto :goto_3

    :catch_a
    move-exception v0

    goto/16 :goto_2

    .line 327
    :catch_b
    move-exception v0

    goto/16 :goto_1

    :catch_c
    move-exception v0

    goto/16 :goto_0
.end method
